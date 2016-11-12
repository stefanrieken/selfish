package selfish.parser;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Stack;

import org.junit.Test;

import selfish.Association;
import selfish.Image;
import selfish.SelfishObject;
import selfish.type.StringType;

public class DefinitionParserTest {

	@Test
	public void testParseAttribute() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = DefinitionParser.parseAttribute(makeReader("@{}"), code, image, current);
		assertEquals("[]", result.toString());
	}

	@Test
	public void testParseDefinitionValue() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = DefinitionParser.parseStaticDef(makeReader(": 42"), code, image, current);
		assertEquals("42", result.toString());
	}

	@Test
	public void testParseLinkReference() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		image.newObject(StringType.instance, "root");
		SelfishObject current = image.newObject(null, null);
		SelfishObject result = DefinitionParser.parseLinkReference(makeReader("/"), code, image, current);
		assertEquals("root", result.toString());
	}

	@Test
	public void testParseLinkReference2() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		SelfishObject other = image.newObject(StringType.instance, "relative");
		current.assocs.put(image.names.add("bla"), new Association(null, null, other));
		SelfishObject result = DefinitionParser.parseLinkReference(makeReader("bla"), code, image, current);
		assertEquals("relative", result.toString());
	}

	@Test
	public void testParseDefinition() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		Association result = DefinitionParser.parseMention(makeReader("@{}value:42"), code, image, current);
		assertEquals("[]", result.attr.toString()); // TODO should attr be of type SimpleObject (not Code)?
		assertEquals("42", result.value.toString());
		assertEquals("42", current.assocs.get(image.names.add("value")).value.toString());
	}

	@Test
	public void testParseCtxDefinition() {
		Stack<Integer> code = new Stack<Integer>();
		Image image = new Image();
		SelfishObject current = image.newObject(null, null);
		Association result = DefinitionParser.parseMention(makeReader("@{}.value:42"), code, image, current);
		assertEquals("[]", result.attr.toString()); // TODO of course code should be empty here
		assertEquals("42", result.value.toString());
		assertEquals("42", current.assocs.get(-image.names.add("value")).value.toString());
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}

}
