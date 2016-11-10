package selfish.parser;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;

public class LiteralParserTest {

	@Test
	public void testParseString() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = LiteralParser.parseString(makeReader("\"bla\""), code, image, current);
		
		assertEquals("bla", result.toString());
	}

	@Test
	public void testParseNumber() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = LiteralParser.parseNumber(makeReader("42"), code, image, current);
		
		assertEquals("42", result.toString());
	}

	@Test
	public void testParseBlock() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = LiteralParser.parseBlock(makeReader("{a.b}"), code, image, current);
		
		assertEquals("[;, a, b]", image.names.toString());
		assertEquals("[1, -2]", result.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}

}
