package selfish.type;

import java.util.Map;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class BlockType implements Type {

	public static BlockType instance = new BlockType();

	public void invoke(Image image, Association meth, Association ctx, Stack<SelfishObject> stack) {
		// TODO wire closures during instantiation
		// TODO take args, return returns (uh, at compile time!)
		// TODO allow methods to live at assoc.attributes
		
		SelfishObject instance = instantiate(image, meth.value, ctx.value);
		Association newCtx = null;

		for (int number : (Stack<Integer>) instance.value) {
			if (number == 0) {
				/* TODO reset stack */
			} else if (number > 0) {
				newCtx = instance.lookup(number);
				stack.push(newCtx.value);
			} else { // number < 0
				stack.pop(); // don't need ctx double mentioned
				Association newMeth = instance.lookup(number);
				newMeth.value.type.invoke(image, newMeth, newCtx, stack);
			}
		}
		
	}

	public SelfishObject instantiate(Image image, SelfishObject meth, SelfishObject ctx) {
		SelfishObject instance = SelfishObject.temporal(meth.type, meth.value);
		for(Map.Entry<Integer,Association> entry : meth.assocs.entrySet()) {
			instance.assocs.put(entry.getKey(), new Association(entry.getValue().attr, entry.getValue().value));
		}
		instance.assocs.put(image.names.add("self"), new Association(null, ctx));
		return instance;
	}
}
