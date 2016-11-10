package selfish.parser;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;

public class InvocationParserTest {

	@Test
	public void testParseBinaryGroup() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("a.b+c.d"), code, image, current);

		// expecting it to prioritize dots over binary operators
		assertEquals("[;, a, b, c, d, +]", image.names.toString());
		assertEquals("[3, -4, 1, -2, -5]", code.toString());
	}

	@Test
	public void testParseDotGroup() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseDotExpression(makeReader("a.b.c+e"), code, image, current);
		
		// expecting it not to parse beyond '+'
		assertEquals("[;, a, b, c]", image.names.toString());
		assertEquals("[1, -2, -3]", code.toString());
	}

	@Test
	public void testParseArgs() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("a.b(c).d(e, f)"), code, image, current);
		
		// expecting it to produce 'f e c a .b .d'
		assertEquals("[;, a, b, c, d, e, f]", image.names.toString());
		assertEquals("[6, 5, 3, 1, -2, -4]", code.toString());
	}

	@Test
	public void testParsePrecedence() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("(a+b)*c"), code, image, current);
		
		// expecting it to produce 'c b a .+ .*
		assertEquals("[;, a, b, +, c, *]", image.names.toString());
		assertEquals("[4, 2, 1, -3, -5]", code.toString());
	}

	@Test
	public void testParsePrecedence2() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("a+(b*c)"), code, image, current);
		
		// expecting it to produce c b .* a .+
		assertEquals("[;, a, b, c, *, +]", image.names.toString());
		assertEquals("[3, 2, -4, 1, -5]", code.toString());
	}

	@Test
	public void testParsePrecedence3() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("(a.b).c(d)"), code, image, current);
		
		// expecting it to produce 'd a -b -c'
		assertEquals("[;, a, b, c, d]", image.names.toString());
		assertEquals("[4, 1, -2, -3]", code.toString());
	}

	@Test
	public void testParsePrecedence4() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("(a+b).c(d)"), code, image, current);
		
		// expecting it to produce 'd b a .+ .c'
		assertEquals("[;, a, b, +, c, d]", image.names.toString());
		assertEquals("[5, 2, 1, -3, -4]", code.toString());
	}

	@Test
	public void testParsePrecedence5() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		InvocationParser.parseBinExpression(makeReader("(a.b) + c.d(e)"), code, image, current);
		
		// expecting it to produce 'e c .d a .b .+'
		assertEquals("[;, a, b, c, d, e, +]", image.names.toString());
		assertEquals("[5, 3, -4, 1, -2, -6]", code.toString());
	}
	
	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
