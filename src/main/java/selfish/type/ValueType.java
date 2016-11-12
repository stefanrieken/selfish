package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public abstract class ValueType extends Type {

	@Override
	public void invoke(Image image, Association meth, Association ctx, Stack<SelfishObject> stack) {
		// values don't do nuthin', it's a security thang
	}
}
