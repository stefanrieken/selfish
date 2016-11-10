package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.SelfishObject;

public class BlockType implements Type {

	public static BlockType instance = new BlockType();

	public void invoke(Association meth, Association ctx, Stack<SelfishObject> stack) {
		// TODO instantiate meth; wire closures
		// TODO allow methods to live at assoc.attributes
		
		SelfishObject obj = meth.value;
		Association newCtx = null;

		for (int number : (Stack<Integer>) obj.value) {
			if (number == 0) {
				/* TODO reset stack */
			} else if (number > 0) {
				newCtx = obj.lookup(number);
				stack.push(newCtx.value);
			} else { // number < 0
				stack.pop(); // don't need ctx double mentioned
				Association newMeth = obj.lookup(number);
				newMeth.value.type.invoke(newMeth, newCtx, stack);
			}
		}
		
	}

}
