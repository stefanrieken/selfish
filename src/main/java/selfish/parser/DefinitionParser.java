package selfish.parser;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class DefinitionParser {

	public static Association parseNameOrDefinition(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		SelfishObject attr = parseAttribute(rd, code, image, current);
		
		String name = SelfishLexer.readName(rd);
		if (name == null) name = SelfishLexer.readBinaryName(rd);
		if (name == null) {
			if (attr != null) throw new RuntimeException("Expected name");
			return null; // no syntax error, just nothing parsed up to this point, so it's no definition
		}

		SelfishObject value = null;
		if(rd.peek() == ':') {
			rd.next();
			value = parseDefinitionValue(rd, code, image, current);
		}

		Association result = null;
		if (attr == null && value == null && name != null) {
			result = current.assocs.get(name);
		}
		
		if (result == null && name != null) {
			result = new Association(attr, value);
			current.assocs.put(name, new Association(attr, value));
		}
		
		code.push(image.names.add(name));
		return result;
	}

	public static SelfishObject parseAttribute(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '@') return null;
		rd.next();
		return LiteralParser.parseBlock(rd, code, image, current);
	}

	public static SelfishObject parseDefinitionValue(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		SelfishObject obj = parseLinkReference(rd, code, image, current);
		if (obj == null) obj= LiteralParser.parseLiteral(rd, code, image, current);
		return obj;
	}

	public static SelfishObject parseLinkReference(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '/') return null;
		rd.next();
		SelfishObject obj = image.objects.get(0);

		String name = SelfishLexer.readName(rd);
		if (name == null) return obj;

		obj = obj.assocs.get(name).value;
		
		while (rd.peek() == '/') {
			rd.next();
			name = SelfishLexer.readName(rd);
			if (name == null) throw new RuntimeException("Expected name");
			obj = obj.assocs.get(name).value;
		}
		
		return obj;
	}
}
