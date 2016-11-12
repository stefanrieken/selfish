package selfish.parser;

import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

/** TODO build in precedence, arglist */
public class InvocationParser {

	/* affects code */
	public static boolean parseBinExpression(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Stack<Integer> lhs = new Stack<>();
		boolean parsedSomething = parseDotExpression(rd, lhs, image, current);

		String binaryName = SelfishLexer.readBinaryName(rd);
		while (binaryName != null) {
			Stack<Integer> rhs = new Stack<Integer>();
			boolean parsedDotGroup = parseDotExpression(rd, rhs, image, current);
			if (!parsedDotGroup)
				throw new ParseException("Expected right hand side of binary expression", rd);

			rhs.addAll(lhs);
			rhs.add(-image.names.add(binaryName));
			lhs = rhs;
			
			binaryName = SelfishLexer.readBinaryName(rd);
		}
		
		code.addAll(lhs);

		return parsedSomething;
	}

	/* affects code */
	public static boolean parseDotExpression(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Stack<Integer> dotExpr = new Stack<>();
		Stack<Integer> precedence = parsePrecedence(rd,image,current);

		if (precedence != null) {
			dotExpr.addAll(precedence);
		} else {
			Association assoc = DefinitionParser.parseMention(rd, dotExpr, image, current);
			if (assoc == null) return false;
			// is already added to expr
		}

		while (rd.peek() == '.') {
			rd.next();
			String name = SelfishLexer.readName(rd);
			if (name == null) name = SelfishLexer.readBinaryName(rd);
			if (name == null) throw new ParseException("Expected name after dot", rd);
			dotExpr.add(-image.names.add(name));
			
			Stack<Integer> args = parseArglist(rd, image, current);
			if (args != null) {
				// prepend the args
				args.addAll(dotExpr);
				dotExpr = args;
			}
		}

		code.addAll(dotExpr);
		return true;
	}

	public static Stack<Integer> parsePrecedence(SelfishReader rd, Image image, SelfishObject current) {
		if (rd.peekNonWs() != '(') return null;
		rd.next();
		Stack<Integer> result = new Stack<>();
		ExpressionParser.parseExpressionList(rd, result, image, current);
		if (!rd.read(')')) throw new ParseException("Expected ')'", rd);
		return result;
	}

	public static Stack<Integer> parseArglist(SelfishReader rd, Image image, SelfishObject current) {
		return parsePrecedence(rd, image, current);
	}
}
