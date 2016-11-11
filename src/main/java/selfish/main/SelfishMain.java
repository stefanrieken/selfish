package selfish.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.ExpressionParser;
import selfish.parser.SelfishReader;
import selfish.type.BlockType;
import selfish.type.IntegerType;

public class SelfishMain {

	public static int main(String ... args) {
		Image image = load(args[0]);
		if (image == null)
			System.out.println("File not found: " + args[0]);
		
		return execute(image);
	}
	
	public static Image load(String filename) {
		Image image = new Image();
		image.names.add("self"); // set at #1

		SelfishObject root = image.newObject(BlockType.instance, new Stack<Integer>());

		try {
			parse(image, new InputStreamReader(SelfishMain.class.getResourceAsStream("/lib/base.selfish")));
			parse(image, new FileReader(filename));
		} catch (FileNotFoundException e) {
			return null;
		}

		return image;
	}

	public static void parse(Image image, Reader reader) {
			SelfishReader rd = new SelfishReader(reader);

			SelfishObject root = image.objects.get(0);
			Stack<Integer> code = (Stack<Integer>) root.value;
			code.clear(); // overwrite any main() code that is in library

			ExpressionParser.parseCode(rd, code, image, root);
			rd.close();
	}

	public static int execute(Image image) {
		Stack<SelfishObject> stack = new Stack<>();

		SelfishObject root = image.objects.get(0);
		Association meth = new Association(null, root);
		stack.push(root);
		root.type.invoke(image, meth, stack);
		
		if (!stack.isEmpty() && stack.peek().type == IntegerType.instance) {
			return (Integer) stack.peek().value;
		}
		
		return 0;
	}
}
