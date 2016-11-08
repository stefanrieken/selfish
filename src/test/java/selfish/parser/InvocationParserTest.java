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
		SelfishObject current = new SelfishObject(null, null);
		InvocationParser.parseBinaryGroup(makeReader("a.b+c.d"), code, image, current);

		// expecting it to prioritize dots over binary operators
		assertEquals("[;, a, b, c, d, +]", image.names.toString());
		assertEquals("[3, -4, 1, -2, -5]", code.toString());
	}

	@Test
	public void testParseDotGroup() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = new SelfishObject(null, null);
		InvocationParser.parseDotGroup(makeReader("a.b.c+e"), code, image, current);
		
		// expecting it not to parse beyond '+'
		assertEquals("[;, a, b, c]", image.names.toString());
		assertEquals("[1, -2, -3]", code.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
