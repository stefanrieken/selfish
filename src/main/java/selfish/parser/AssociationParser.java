package selfish.parser;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.type.BlockType;
import selfish.type.IntegerType;

/* Mostly parses association *references*, but they may be first mentions (~= definitions) . */

public class AssociationParser {

	public static Association parseAssociation(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Association assoc = parseLiteral(rd, code, image, current);
		if (assoc == null) assoc = DefinitionParser.parseNameOrDefinition(rd, code, image, current);
		return assoc;
	}
	
	public static Association parseReference(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		String name = SelfishLexer.readName(rd);
		if (name == null) return null;
		Association assoc = current.assocs.get(name);
		if (assoc == null) throw new RuntimeException("Name not found: " + name);
		return assoc;
	}

	public static Association parseLiteral(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		SelfishObject obj = parseBlock(rd, code, image, current);
		if (obj == null) obj = parseNumber(rd, code, image, current);
		if (obj == null) obj = parseString(rd, code, image, current);
		if (obj == null) return null;
		else return new Association(null, obj);
	}
	
	public static SelfishObject parseBlock(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '{') return null;
		rd.next();

		SelfishObject codeBlock = new SelfishObject(BlockType.instance, null);
		// TODO wire with base library
		Stack<Integer> blockCode = new Stack<Integer>();
		ExpressionParser.parseCode(rd, blockCode, image, codeBlock);
		codeBlock.value = blockCode;

		if (!rd.read('}')) throw new RuntimeException("Expected '}'");
	
		return codeBlock;
	}
	
	public static SelfishObject parseNumber(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Integer number = SelfishLexer.readNumber(rd);
		if (number == null) return null;
		else return new SelfishObject(IntegerType.instance, number);
	}

	public static SelfishObject parseString(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		String string = SelfishLexer.readString(rd);
		if (string == null) return null;
		else return new SelfishObject(IntegerType.instance, string);
	}
}
