package selfish.parser;

public class SelfishLexer {
	
	public static Integer readNumber(SelfishReader rd) {
		String result = "";

		int ch = rd.peekNonWs();
		while (ch != -1 && Character.isDigit(ch)) {
			result += (char) ch;
			ch = rd.peekNext();
		}
		
		if (!result.isEmpty()) return Integer.valueOf(result);
		else return null;
	}
	
	public static String readString(SelfishReader rd) {
		int ch = rd.peekNonWs();
		if(ch != '"') return null;

		String result = "";
		ch = rd.peekNext();
		while (ch != '"') {
			if (ch == '\\') {
				ch = rd.peekNext();
				if (ch == 'r') ch = '\r';
				if (ch == 'n') ch = '\n';
				if (ch == 't') ch = '\t';
				if (ch == 'b') ch = '\b';
				if (ch == 'f') ch = '\f';
			}

			result += (char) ch;
			ch = rd.peekNext();
		}
		
		if(!rd.read('"')) throw new RuntimeException("String not closed");

		return result;
	}

	public static String readName(SelfishReader rd) {
		int ch = rd.peekNonWs();
		if (! Character.isJavaIdentifierStart(ch)) return null;
		
		String result = "";
		
		do {
			result += (char) ch;
			ch = rd.peekNext();
		} while (ch != -1 && Character.isJavaIdentifierPart(ch));
		
		return result;
	}

	public static String readBinaryName(SelfishReader rd) {
		int ch = rd.peekNonWs();
		if (!isBinaryNamePart(ch)) return null;
		
		String result = "";
		
		do {
			result += (char) ch;
			ch = rd.peekNext();
		} while (ch != -1 && isBinaryNamePart(ch));
		
		return result;
	}

	private static boolean isBinaryNamePart(int ch) {
		return ch == '!' || ch == '%' || ch == '&' || ch == '*' || ch == '+'
				|| ch == '-' || ch == '/' || ch == '<' || ch == '='
				|| ch == '>' || ch == '?' || ch == '|' || ch == '~'; 
	}
}
