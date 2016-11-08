package selfish.parser;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Test;

public class SelfishLexerTest {
	
	private SelfishLexer lexer = new SelfishLexer();

	@Test
	public void testReadBinaryName() {
		assertEquals("!=", lexer.readBinaryName(makeReader("!=asdf")));
		assertNull(lexer.readBinaryName(makeReader("asdf!=")));
	}
	
	@Test
	public void testReadName() {
		assertEquals("myName01", lexer.readName(makeReader("myName01{")));
		assertNull(lexer.readName(makeReader("01myName")));
	}

	@Test
	public void testReadNumber() {
		assertEquals(1, lexer.readNumber(makeReader("01myName")).intValue());
		assertNull(lexer.readNumber(makeReader("myName01")));
	}

	@Test
	public void testReadString() {
		assertEquals("escaped\nstring", lexer.readString(makeReader("\"escap\\ed\nstring\"")));
		assertNull(lexer.readString(makeReader("myName01")));
	}

	private SelfishReader makeReader(String input) {
		return new SelfishReader(new StringReader(input));
	}
}
