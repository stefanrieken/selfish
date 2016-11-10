package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.SelfishObject;

public interface Type {

	public void invoke(Association meth, Association ctx, Stack<SelfishObject> stack);
}
