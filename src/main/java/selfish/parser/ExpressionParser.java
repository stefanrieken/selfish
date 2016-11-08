package selfish.parser;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;

public class ExpressionParser {
	
	public static boolean parseCode(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		int size = code.size();

		while (parseExpressionList(rd, code, image, current) && rd.peek() == ';') {
			code.push(0); // ';'
			rd.next();
			parseExpressionList(rd, code, image, current);
		}

		return code.size() > size;
	}
	
	public static boolean parseExpressionList(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {

		boolean done = false;

		int size = code.size();

		while(!done && rd.peek() != -1) {

			boolean success = parseBracketed(rd, code, image, current);
			if (!success) success = InvocationParser.parseInvocation(rd, code, image, current);
			done = !success;
			
			if (rd.peekNonWs() == ',') {
				
			}
			// TODO comma-separated
		}
		
		return code.size() > size;
	}
	
	public static boolean parseBracketed(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		if (rd.peek() != '(') return false;
		rd.next();
		
		while(rd.peek() != ')') {
			if(!parseExpressionList(rd, code, image, current))
				throw new RuntimeException("Expected expressionlist");
		}
		rd.next();
		
		return true;
	}
}
