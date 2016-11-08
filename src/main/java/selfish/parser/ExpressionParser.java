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
		boolean precede = false;

		Stack<Integer> expressionList = new Stack<>();

		while(!done && rd.peek() != -1) {
			Stack<Integer> expression = new Stack<>();
			boolean success = parseBracketed(rd, expression, image, current); // TODO brackets have a different code insertion order
			if (!success) success = InvocationParser.parseInvocation(rd, expression, image, current);
			done = !success;
			
			if(precede) {
				expression.addAll(expressionList);
				expressionList = expression;
			}
			else expressionList.addAll(expression);
				
			if (rd.peekNonWs() == ',') {
				rd.next();
				precede = true;
			} else precede = false;
		}
		
		code.addAll(expressionList);
		
		return expressionList.size() > 0;
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
