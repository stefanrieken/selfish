package selfish.parser;

public class ParseException extends RuntimeException {

	public ParseException(String error, SelfishReader rd) {
		super(error + " at " + rd.line + ":" + rd.column);
	}
}
