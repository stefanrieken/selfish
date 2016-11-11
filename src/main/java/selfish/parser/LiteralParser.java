package selfish.parser;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;
import selfish.type.BlockType;
import selfish.type.IntegerType;
import selfish.type.ReflectiveType;
import selfish.type.StringType;
import selfish.type.Type;

/* Parses and returns object literals. Does not add to the current object */
public class LiteralParser {

	static Type[] literalTypes = new Type[] {
			BlockType.instance,
			IntegerType.instance,
			StringType.instance,
			ReflectiveType.instance
	};

	public static SelfishObject parseLiteral(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		for (Type type : literalTypes) {
			SelfishObject obj = type.parse(rd, code, image, current);
			if (obj != null) return obj;
		}
		
		return null;
	}
}
