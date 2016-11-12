package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishReader;

public abstract class Type {

	public abstract SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current);

	public abstract void invoke(Image image, Association meth, Association ctx, Stack<SelfishObject> stack);
	
	public abstract String getName();

	//
	// Reflective methods from here
	//
	public void assoc_set(Association ctx, Image image, Stack<SelfishObject> stack) {
		ctx.value = stack.pop();
	}
}
