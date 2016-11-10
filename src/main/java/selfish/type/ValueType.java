package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.SelfishObject;

public abstract class ValueType implements Type {

	public void invoke(Association meth, Association ctx, Stack<SelfishObject> stack) {
		// values don't do nuthin', it's a security thang
	}

}
