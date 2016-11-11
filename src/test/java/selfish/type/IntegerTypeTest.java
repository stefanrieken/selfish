package selfish.type;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishReader;

public class IntegerTypeTest {

	@Test
	public void testParseNumber() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = IntegerType.instance.parse(makeReader("42"), code, image, current);
		
		assertEquals("42", result.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
