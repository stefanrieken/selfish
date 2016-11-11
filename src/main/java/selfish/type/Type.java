package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public interface Type {

	public void invoke(Image image, Association meth, Stack<SelfishObject> stack);
}
