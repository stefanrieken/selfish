package selfish.type;

import java.util.Map;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.ExpressionParser;
import selfish.parser.LiteralParser;
import selfish.parser.ParseException;
import selfish.parser.SelfishReader;

public class BlockType extends Type {

	public static BlockType instance = new BlockType();

	@Override
	public void invoke(Image image, Association meth, Association ctx, Stack<SelfishObject> stack) {
		// TODO wire closures during instantiation
		// TODO take args, return returns (uh, at compile time!)
		
		SelfishObject instance = instantiate(image, meth.value, ctx.value);
		Association newCtx = null;

		for (int number : (Stack<Integer>) instance.value) {
			if (number == 0) {
				/* TODO reset stack */
			} else if (number > 0) {
				newCtx = instance.lookup(number, true);
				stack.push(newCtx.value);
			} else { // number < 0
				stack.pop(); // we already supply ctx
				// TODO allow methods to live at assoc.attributes (= newCtx)
				Association newMeth = null;
				if(newCtx.type != null) newMeth = newCtx.type.lookup(Math.abs(number), true);
				if(newMeth == null) newMeth = newCtx.value.lookup(Math.abs(number), true);
				if(newMeth == null) throw new RuntimeException("Name not found: " + image.names.lookup(Math.abs(number)));
				newMeth.value.type.invoke(image, newMeth, newCtx, stack);
			}
		}
		
	}

	public SelfishObject instantiate(Image image, SelfishObject meth, SelfishObject ctx) {
		SelfishObject instance = SelfishObject.temporal(meth.type, meth.value);
		for(Map.Entry<Integer,Association> entry : meth.assocs.entrySet()) {
			instance.assocs.put(entry.getKey(), new Association(entry.getValue().attr, getAssocParent(image), entry.getValue().value));
		}

		// TODO quick fix: delete earlier positive version. This should be done on a higher level!
		instance.assocs.remove(image.names.add("self"));
		instance.assocs.put(-image.names.add("self"), new Association(null, getAssocParent(image), ctx));
		return instance;
	}

	public SelfishObject getAssocParent(Image image) {
		return LiteralParser.findObject(image, "selfish", "association");
	}

	@Override
	public SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '{') return null;
		rd.next();
		
		Stack<Integer> blockCode = new Stack<>();
		SelfishObject codeBlock = image.newObject(BlockType.instance, blockCode);
		ExpressionParser.parseCode(rd, blockCode, image, codeBlock);

		if (!rd.readNonWs('}')) throw new ParseException("Expected '}'", rd);

		return codeBlock;
	}

	@Override
	public String getName() {
		return "code";
	}
}
