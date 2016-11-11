package selfish.type;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishLexer;
import selfish.parser.SelfishReader;

public class StringType extends ValueType {

	public static StringType instance = new StringType();

	public SelfishObject parse(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		String string = SelfishLexer.readString(rd);
		if (string == null) return null;
		else return image.newObject(IntegerType.instance, string);
	}
}
