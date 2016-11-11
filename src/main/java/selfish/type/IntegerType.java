package selfish.type;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishLexer;
import selfish.parser.SelfishReader;

public class IntegerType extends ValueType {

	public static IntegerType instance = new IntegerType();

	public SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Integer number = SelfishLexer.readNumber(rd);
		if (number == null) return null;
		else return image.newObject(IntegerType.instance, number);
	}
}
