package selfish.parser;

import java.util.LinkedList;
import java.util.Stack;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class InvocationParser {

	/* affects code */
	public static boolean parseInvocation(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		return parseBinaryGroup(rd, code, image, current);
	}

	/* affects code */
	public static boolean parseBinaryGroup(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Stack<Integer> lhs = new Stack<>();
		boolean parsedSomething = parseDotGroup(rd, lhs, image, current);

		String binaryName = SelfishLexer.readBinaryName(rd);
		while (binaryName != null) {
			Stack<Integer> rhs = new Stack<Integer>();
			boolean parsedDotGroup = parseDotGroup(rd, rhs, image, current);
			if (!parsedDotGroup)
				throw new RuntimeException("Expected right hand side of binary expression");

			rhs.addAll(lhs);
			rhs.add(-image.names.add(binaryName));
			lhs = rhs;
			
			binaryName = SelfishLexer.readBinaryName(rd);
		}
		
		code.addAll(lhs);

		return parsedSomething;
	}
	
	/* affects code */
	public static boolean parseDotGroup(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		Association assoc = AssociationParser.parseAssociation(rd, code, image, current);
		if (assoc == null) return false;

		while (rd.peek() == '.') {
			rd.next();
			String name = SelfishLexer.readName(rd);
			if (name == null) name = SelfishLexer.readBinaryName(rd);
			if (name == null) throw new RuntimeException("Expected name after dot");
			code.add(-image.names.add(name));
		}
		
		// TODO build up the code
		return true;
	}
}
