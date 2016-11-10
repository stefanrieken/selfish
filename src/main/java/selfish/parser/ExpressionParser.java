package selfish.parser;

import java.util.Stack;

import selfish.Image;
import selfish.SelfishObject;

public class ExpressionParser {
	
	public static boolean parseCode(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {
		int size = code.size();
		int startOfExpression = code.size();

		while (parseExpressionList(rd, code, image, current) && rd.peek() == ';') {
			rd.next();
			code.push(0); // ';'
			
			clearCodeOnlyContainingReferences(code, startOfExpression);
			startOfExpression = code.size();
		}

		return code.size() > size;
	}
	
	public static void clearCodeOnlyContainingReferences(Stack<Integer> code, int from) {
		
		boolean foundInvocation = false;
		for (int i=from; i<code.size(); i++) {
			if (code.get(i) < 0) {
				foundInvocation = true;
				break;
			}
		}
		
		if(!foundInvocation) {
			while (code.size() > from) {
				code.pop();
			}
		}
	}

	public static boolean parseExpressionList(SelfishReader rd, Stack<Integer> code, Image image, SelfishObject current) {

		boolean done = false;
		boolean precede = false;

		Stack<Integer> expressionList = new Stack<>();

		while(!done && rd.peek() != -1) {
			Stack<Integer> expression = new Stack<>();
			done = !InvocationParser.parseBinExpression(rd, expression, image, current);
			
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
}
