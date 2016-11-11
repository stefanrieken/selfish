package selfish.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
		try {
			SelfishReader rd = new SelfishReader(new FileReader(filename));

			Stack<Integer> code = new Stack<>();
			Image image = new Image();

			image.names.add("self"); // set at #1

			SelfishObject root = image.newObject(BlockType.instance,code);
			image.objects.add(root);
			ExpressionParser.parseCode(rd, code, image, root);
			
			rd.close();
		return image;
		} catch (FileNotFoundException e) {
			return null;
		}
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
