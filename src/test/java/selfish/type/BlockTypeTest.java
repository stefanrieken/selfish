package selfish.type;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;
import selfish.parser.SelfishReader;

public class BlockTypeTest {

	@Test
	public void testParseBlock() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = BlockType.instance.parse(makeReader("{a.b}"), code, image, current);
		
		assertEquals("[;, a, b]", image.names.toString());
		assertEquals("[1, -2]", result.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
