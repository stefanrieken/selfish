package selfish.parser;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

import selfish.Image;
import selfish.SelfishObject;

public class ExpressionParserTest {
	
	@Test
	public void testParseCode() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);

		SelfishReader rd = new SelfishReader(new InputStreamReader(getClass().getResourceAsStream("/examples/fibonacci.selfish")));
		ExpressionParser.parseCode(rd, code, image, current);
		
		// Hard to make good assertions at this level
		// (unless we want to test *everything* here).
		// So this test mainly proves that parseCode
		// as a whole doesn't throw an exception on
		// input we deem valid (but is not necessarily
		// known to run).
		//
		// Parse details are tested in the other parser tests.
		// Testing execution should be covered elsewhere.
	}

	@Test
	public void testParseExpressionList() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		ExpressionParser.parseExpressionList(makeReader("a.b c.d"), code, image, current);
		assertEquals("[;, a, b, c, d]", image.names.toString());
		assertEquals("[1, -2, 3, -4]", code.toString());
	}

	@Test
	public void testParseCommaExpressionList() {
		Stack<Integer> code = new Stack<>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		ExpressionParser.parseExpressionList(makeReader("a.b, c.d"), code, image, current);
		assertEquals("[;, a, b, c, d]", image.names.toString());
		assertEquals("[3, -4, 1, -2]", code.toString());
	}

	@Test
	public void testClearCodeOnlyContainingReferences() {
		Stack<Integer> code = new Stack<>();
		code.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,0,1,2,3}));

		// test with much on stack
		ExpressionParser.clearCodeOnlyContainingReferences(code, 6);
		assertEquals(6, code.size());
		
		// test with last bit on stack
		ExpressionParser.clearCodeOnlyContainingReferences(code, 0);
		assertEquals(0, code.size());
		
		// test with nothing on stack
		ExpressionParser.clearCodeOnlyContainingReferences(code, 0);
		assertEquals(0, code.size());

		// test if it keeps code with invocations
		code.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,0,1,2,-3}));
		ExpressionParser.clearCodeOnlyContainingReferences(code, 6);
		assertEquals(9, code.size());
}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
	
}
