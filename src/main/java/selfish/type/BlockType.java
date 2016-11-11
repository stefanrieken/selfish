package selfish.type;

import java.util.Map;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class BlockType implements Type {

	public static BlockType instance = new BlockType();

	public void invoke(Image image, Association meth, Stack<SelfishObject> stack) {
		// TODO wire closures during instantiation
		// TODO take args, return returns (uh, at compile time!)
		
		SelfishObject instance = instantiate(image, meth.value, stack.pop());
		Association newCtx = null;

		for (int number : (Stack<Integer>) instance.value) {
			if (number == 0) {
				/* TODO reset stack */
			} else if (number > 0) {
				newCtx = instance.lookup(number);
				stack.push(newCtx.value);
			} else { // number < 0
				// TODO allow methods to live at assoc.attributes (= newCtx)
				Association newMeth = instance.lookup(number);
				newMeth.value.type.invoke(image, newMeth, stack);
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
