// $ANTLR 3.5.2 Selfish.g 2016-11-09 19:57:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SelfishLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int BNAME=4;
	public static final int NAME=5;
	public static final int NUMBER=6;
	public static final int STRING=7;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SelfishLexer() {} 
	public SelfishLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SelfishLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Selfish.g"; }

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:2:6: ( '(' )
			// Selfish.g:2:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:3:6: ( ')' )
			// Selfish.g:3:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:4:7: ( ',' )
			// Selfish.g:4:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:5:7: ( '.' )
			// Selfish.g:5:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:6:7: ( '/' )
			// Selfish.g:6:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:7:7: ( ':' )
			// Selfish.g:7:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:8:7: ( ';' )
			// Selfish.g:8:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:9:7: ( '@' )
			// Selfish.g:9:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:10:7: ( '{' )
			// Selfish.g:10:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:11:7: ( '}' )
			// Selfish.g:11:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:39:9: ( ( '0' .. '9' )+ )
			// Selfish.g:39:11: ( '0' .. '9' )+
			{
			// Selfish.g:39:11: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Selfish.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:40:9: ( '\"' (~ '\"' )* '\"' )
			// Selfish.g:40:11: '\"' (~ '\"' )* '\"'
			{
			match('\"'); 
			// Selfish.g:40:15: (~ '\"' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Selfish.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:41:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// Selfish.g:41:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Selfish.g:41:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Selfish.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "BNAME"
	public final void mBNAME() throws RecognitionException {
		try {
			int _type = BNAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Selfish.g:42:8: ( ( '!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+ )
			// Selfish.g:42:10: ( '!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+
			{
			// Selfish.g:42:10: ( '!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='!'||(LA4_0 >= '%' && LA4_0 <= '&')||(LA4_0 >= '*' && LA4_0 <= '+')||LA4_0=='-'||LA4_0=='/'||(LA4_0 >= '<' && LA4_0 <= '?')||LA4_0=='|'||LA4_0=='~') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// Selfish.g:
					{
					if ( input.LA(1)=='!'||(input.LA(1) >= '%' && input.LA(1) <= '&')||(input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1) >= '<' && input.LA(1) <= '?')||input.LA(1)=='|'||input.LA(1)=='~' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BNAME"

	@Override
	public void mTokens() throws RecognitionException {
		// Selfish.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | NUMBER | STRING | NAME | BNAME )
		int alt5=14;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt5=1;
			}
			break;
		case ')':
			{
			alt5=2;
			}
			break;
		case ',':
			{
			alt5=3;
			}
			break;
		case '.':
			{
			alt5=4;
			}
			break;
		case '/':
			{
			int LA5_5 = input.LA(2);
			if ( (LA5_5=='!'||(LA5_5 >= '%' && LA5_5 <= '&')||(LA5_5 >= '*' && LA5_5 <= '+')||LA5_5=='-'||LA5_5=='/'||(LA5_5 >= '<' && LA5_5 <= '?')||LA5_5=='|'||LA5_5=='~') ) {
				alt5=14;
			}

			else {
				alt5=5;
			}

			}
			break;
		case ':':
			{
			alt5=6;
			}
			break;
		case ';':
			{
			alt5=7;
			}
			break;
		case '@':
			{
			alt5=8;
			}
			break;
		case '{':
			{
			alt5=9;
			}
			break;
		case '}':
			{
			alt5=10;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt5=11;
			}
			break;
		case '\"':
			{
			alt5=12;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=13;
			}
			break;
		case '!':
		case '%':
		case '&':
		case '*':
		case '+':
		case '-':
		case '<':
		case '=':
		case '>':
		case '?':
		case '|':
		case '~':
			{
			alt5=14;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// Selfish.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// Selfish.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// Selfish.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// Selfish.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// Selfish.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// Selfish.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// Selfish.g:1:44: T__14
				{
				mT__14(); 

				}
				break;
			case 8 :
				// Selfish.g:1:50: T__15
				{
				mT__15(); 

				}
				break;
			case 9 :
				// Selfish.g:1:56: T__16
				{
				mT__16(); 

				}
				break;
			case 10 :
				// Selfish.g:1:62: T__17
				{
				mT__17(); 

				}
				break;
			case 11 :
				// Selfish.g:1:68: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 12 :
				// Selfish.g:1:75: STRING
				{
				mSTRING(); 

				}
				break;
			case 13 :
				// Selfish.g:1:82: NAME
				{
				mNAME(); 

				}
				break;
			case 14 :
				// Selfish.g:1:87: BNAME
				{
				mBNAME(); 

				}
				break;

		}
	}



}
