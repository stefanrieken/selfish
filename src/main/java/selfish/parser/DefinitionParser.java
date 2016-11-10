package selfish.parser;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class DefinitionParser {

	/**
	 *  A 'mention' is either a definition or a reference.
	 * It is only known to be a reference when only a name
	 * is parsed, and that name already exists.
	 */
	public static Association parseMention(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		SelfishObject attr = parseAttribute(rd, code, image, current);

		Association assoc = parseNamedDef(rd, code, image, current, attr);
		if (assoc == null) {
			SelfishObject value = LiteralParser.parseLiteral(rd, code, image, current);
			if (value != null) {
				int number = image.names.add("");
				assoc = new Association(attr, value);
				current.assocs.put(number, assoc);
				code.add(number);
			}
		}

		if (assoc == null) {
			if (attr == null) return null; // nothing parsed
			else throw new ParseException("Expected named def or literal", rd);
		}
		
		// TODO implicit-self-based invocation
		// Stack<Integer> args = InvocationParser.parseArgList();

		if (attr != null) {
			assoc.attr = attr;
		}
		
		return assoc;
	}

	public static SelfishObject parseAttribute(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peekNonWs() != '@') return null;
		rd.next();
		return LiteralParser.parseBlock(rd, code, image, current);
	}

	/* affects current, code */
	public static Association parseNamedDef(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current, SelfishObject attr) {

		int sign = 1;
		/* This part will only give the expected outcome (a named definition of a context object) */
		/* when other, more pressing interepretations, such as a dotInvocation, were considered before this one. */
		if (rd.peek() == '.') {
			rd.next();
			sign = -1;
		}

		String name = SelfishLexer.readName(rd);
		if (name == null) name = SelfishLexer.readBinaryName(rd);
		if (name == null) {
			if (sign == -1) throw new ParseException("expected name", rd);
			return null;
		}

		int number = image.names.add(name);

		Association assoc = null;

		SelfishObject value = parseStaticDef(rd, code, image, current);

		if (value != null || attr != null) {
			assoc = new Association(attr, value);
			current.assocs.put(sign * number, assoc);
		} else { // neither value nor attr known, so could be new, could be reference
			assoc = current.lookup(number);
			if (assoc == null) {
				assoc = new Association(null, null);
				current.assocs.put(sign * number, assoc);
			}
		}
		
		code.add(number); // no sign here! this is a definition, not a dotInvocation

		return assoc;
	}
	
	public static SelfishObject parseStaticDef(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peekNonWs() != ':') return null;
		rd.next();
		
		SelfishObject obj = parseLinkReference(rd, code, image, current);
		if (obj == null) obj = LiteralParser.parseLiteral(rd, code, image, current);
		
		return obj;
	}

	public static SelfishObject parseLinkReference(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peekNonWs() != '/') return null;
		rd.next();
		SelfishObject obj = image.objects.get(0);

		String name = SelfishLexer.readName(rd);
		if (name == null) return obj;

		obj = obj.assocs.get(name).value;
		
		while (rd.peek() == '/') {
			rd.next();
			name = SelfishLexer.readName(rd);
			if (name == null) throw new ParseException("Expected name", rd);
			obj = obj.assocs.get(name).value;
		}
		
		return obj;
	}
}
