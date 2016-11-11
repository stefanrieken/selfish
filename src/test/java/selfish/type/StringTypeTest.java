package selfish.type;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.LiteralParser;
import selfish.parser.SelfishReader;

public class StringTypeTest {

	@Test
	public void testParseString() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = StringType.instance.parse(makeReader("\"bla\""), code, image, current);
		
		assertEquals("bla", result.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
