package selfish.parser;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;
import selfish.type.BlockType;
import selfish.type.IntegerType;

/* Parses and returns object literals. Does not add to the current object */
public class LiteralParser {
	
	public static SelfishObject parseLiteral(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		SelfishObject obj = parseBlock(rd, code, image, current);
		if (obj == null) obj = parseNumber(rd, code, image, current);
		if (obj == null) obj = parseString(rd, code, image, current);
		return obj;
	}
	
	public static SelfishObject parseBlock(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '{') return null;
		rd.next();
		
		Stack<Integer> blockCode = new Stack<>();
		SelfishObject codeBlock = image.newObject(BlockType.instance, blockCode);
		ExpressionParser.parseCode(rd, blockCode, image, codeBlock);

		if (!rd.readNonWs('}')) throw new ParseException("Expected '}'", rd);
	
		return codeBlock;
	}
	
	public static SelfishObject parseNumber(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Integer number = SelfishLexer.readNumber(rd);
		if (number == null) return null;
		else return image.newObject(IntegerType.instance, number);
	}

	public static SelfishObject parseString(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		String string = SelfishLexer.readString(rd);
		if (string == null) return null;
		else return image.newObject(IntegerType.instance, string);
	}

}
