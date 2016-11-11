package selfish.type;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishReader;

public interface Type {

	public SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current);

	public void invoke(Image image, Association meth, Stack<SelfishObject> stack);
}
