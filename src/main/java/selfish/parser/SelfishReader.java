package selfish.parser;

import java.io.IOException;
import java.io.Reader;

public class SelfishReader {

	private Reader reader;
	
	private Integer buffer;

	public SelfishReader(Reader reader) {
		this.reader = reader;
	}

	public int readNonWs() {
		int ch = read();
		
		while(Character.isWhitespace(ch))
			ch = read();
		
		return ch;
	}

	public int read() {
		if (buffer != null) {
			int result = buffer.intValue();
			buffer = null;
			return result;
		} else {
			return readNew();
		}
	}
	
	private int readNew() {
		try {
			return reader.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void next() {
		read();
	}

	public int peekNonWs() {
		while (buffer == null || Character.isWhitespace(buffer))
			buffer = readNew();
		return buffer;
	}

	public int peek() {
		if (buffer == null) buffer = readNew();
		return buffer;
	}

	public boolean read(char ch) {
		if (peek() == ch) {
			buffer = null;
			return true;
		}
		return false;
	}

	public int peekNext() {
		read();
		return peek();
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
