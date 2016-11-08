package selfish.parser;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;

public class ExpressionParserTest {
	
	@Test
	public void testParseExpressionList() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = new SelfishObject(null, null);
		ExpressionParser.parseExpressionList(makeReader("a.b c.d"), code, image, current);
		assertEquals("[;, a, b, c, d]", image.names.toString());
		assertEquals("[1, -2, 3, -4]", code.toString());
	}

	@Test
	public void testParseCommaExpressionList() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = new SelfishObject(null, null);
		ExpressionParser.parseExpressionList(makeReader("a.b, c.d"), code, image, current);
		assertEquals("[;, a, b, c, d]", image.names.toString());
		assertEquals("[3, -4, 1, -2]", code.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
	
}
