// $ANTLR 3.5.2 Selfish.g 2016-11-09 19:57:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SelfishParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BNAME", "NAME", "NUMBER", "STRING", 
		"'('", "')'", "','", "'.'", "'/'", "':'", "';'", "'@'", "'{'", "'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SelfishParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SelfishParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SelfishParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Selfish.g"; }



	// $ANTLR start "start_rule"
	// Selfish.g:3:1: start_rule : code ;
	public final void start_rule() throws RecognitionException {
		try {
			// Selfish.g:3:12: ( code )
			// Selfish.g:3:14: code
			{
			pushFollow(FOLLOW_code_in_start_rule10);
			code();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start_rule"



	// $ANTLR start "code"
	// Selfish.g:10:1: code : ( expressionlist ( ';' expressionlist )* )? ;
	public final void code() throws RecognitionException {
		try {
			// Selfish.g:10:7: ( ( expressionlist ( ';' expressionlist )* )? )
			// Selfish.g:10:9: ( expressionlist ( ';' expressionlist )* )?
			{
			// Selfish.g:10:9: ( expressionlist ( ';' expressionlist )* )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= NAME && LA2_0 <= 8)||(LA2_0 >= 15 && LA2_0 <= 16)) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// Selfish.g:10:10: expressionlist ( ';' expressionlist )*
					{
					pushFollow(FOLLOW_expressionlist_in_code28);
					expressionlist();
					state._fsp--;

					// Selfish.g:10:25: ( ';' expressionlist )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==14) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// Selfish.g:10:26: ';' expressionlist
							{
							match(input,14,FOLLOW_14_in_code31); 
							pushFollow(FOLLOW_expressionlist_in_code33);
							expressionlist();
							state._fsp--;

							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "code"



	// $ANTLR start "expressionlist"
	// Selfish.g:11:1: expressionlist : expression ( ( ',' )? expression )* ;
	public final void expressionlist() throws RecognitionException {
		try {
			// Selfish.g:11:16: ( expression ( ( ',' )? expression )* )
			// Selfish.g:11:18: expression ( ( ',' )? expression )*
			{
			pushFollow(FOLLOW_expression_in_expressionlist45);
			expression();
			state._fsp--;

			// Selfish.g:11:29: ( ( ',' )? expression )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= NAME && LA4_0 <= 8)||LA4_0==10||(LA4_0 >= 15 && LA4_0 <= 16)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// Selfish.g:11:30: ( ',' )? expression
					{
					// Selfish.g:11:30: ( ',' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==10) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// Selfish.g:11:31: ','
							{
							match(input,10,FOLLOW_10_in_expressionlist49); 
							}
							break;

					}

					pushFollow(FOLLOW_expression_in_expressionlist53);
					expression();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expressionlist"



	// $ANTLR start "expression"
	// Selfish.g:12:1: expression : binaryGroup ;
	public final void expression() throws RecognitionException {
		try {
			// Selfish.g:12:12: ( binaryGroup )
			// Selfish.g:12:14: binaryGroup
			{
			pushFollow(FOLLOW_binaryGroup_in_expression65);
			binaryGroup();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "binaryGroup"
	// Selfish.g:17:1: binaryGroup : dotGroup ( BNAME dotGroup )? ;
	public final void binaryGroup() throws RecognitionException {
		try {
			// Selfish.g:17:13: ( dotGroup ( BNAME dotGroup )? )
			// Selfish.g:17:15: dotGroup ( BNAME dotGroup )?
			{
			pushFollow(FOLLOW_dotGroup_in_binaryGroup77);
			dotGroup();
			state._fsp--;

			// Selfish.g:17:24: ( BNAME dotGroup )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BNAME) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// Selfish.g:17:25: BNAME dotGroup
					{
					match(input,BNAME,FOLLOW_BNAME_in_binaryGroup80); 
					pushFollow(FOLLOW_dotGroup_in_binaryGroup82);
					dotGroup();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "binaryGroup"



	// $ANTLR start "dotGroup"
	// Selfish.g:18:1: dotGroup : ( precedence | assoc ) ( '.' ( BNAME | NAME ) {...}? arglist )? ;
	public final void dotGroup() throws RecognitionException {
		try {
			// Selfish.g:18:10: ( ( precedence | assoc ) ( '.' ( BNAME | NAME ) {...}? arglist )? )
			// Selfish.g:18:12: ( precedence | assoc ) ( '.' ( BNAME | NAME ) {...}? arglist )?
			{
			// Selfish.g:18:12: ( precedence | assoc )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==8) ) {
				alt6=1;
			}
			else if ( ((LA6_0 >= NAME && LA6_0 <= STRING)||(LA6_0 >= 15 && LA6_0 <= 16)) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Selfish.g:18:13: precedence
					{
					pushFollow(FOLLOW_precedence_in_dotGroup96);
					precedence();
					state._fsp--;

					}
					break;
				case 2 :
					// Selfish.g:18:24: assoc
					{
					pushFollow(FOLLOW_assoc_in_dotGroup98);
					assoc();
					state._fsp--;

					}
					break;

			}

			// Selfish.g:18:32: ( '.' ( BNAME | NAME ) {...}? arglist )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==11) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// Selfish.g:18:34: '.' ( BNAME | NAME ) {...}? arglist
					{
					match(input,11,FOLLOW_11_in_dotGroup104); 
					if ( (input.LA(1) >= BNAME && input.LA(1) <= NAME) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					if ( !((arglist)) ) {
						throw new FailedPredicateException(input, "dotGroup", "arglist");
					}
					pushFollow(FOLLOW_arglist_in_dotGroup115);
					arglist();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dotGroup"



	// $ANTLR start "arglist"
	// Selfish.g:19:1: arglist : '(' expressionlist ')' ;
	public final void arglist() throws RecognitionException {
		try {
			// Selfish.g:19:10: ( '(' expressionlist ')' )
			// Selfish.g:19:12: '(' expressionlist ')'
			{
			match(input,8,FOLLOW_8_in_arglist129); 
			pushFollow(FOLLOW_expressionlist_in_arglist131);
			expressionlist();
			state._fsp--;

			match(input,9,FOLLOW_9_in_arglist133); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arglist"



	// $ANTLR start "precedence"
	// Selfish.g:20:1: precedence : '(' expressionlist ')' ;
	public final void precedence() throws RecognitionException {
		try {
			// Selfish.g:20:12: ( '(' expressionlist ')' )
			// Selfish.g:20:14: '(' expressionlist ')'
			{
			match(input,8,FOLLOW_8_in_precedence141); 
			pushFollow(FOLLOW_expressionlist_in_precedence143);
			expressionlist();
			state._fsp--;

			match(input,9,FOLLOW_9_in_precedence145); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "precedence"



	// $ANTLR start "assoc"
	// Selfish.g:25:1: assoc : ( literal | definition );
	public final void assoc() throws RecognitionException {
		try {
			// Selfish.g:25:8: ( literal | definition )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( ((LA8_0 >= NUMBER && LA8_0 <= STRING)||LA8_0==16) ) {
				alt8=1;
			}
			else if ( (LA8_0==NAME||LA8_0==15) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// Selfish.g:25:10: literal
					{
					pushFollow(FOLLOW_literal_in_assoc159);
					literal();
					state._fsp--;

					}
					break;
				case 2 :
					// Selfish.g:25:20: definition
					{
					pushFollow(FOLLOW_definition_in_assoc163);
					definition();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assoc"



	// $ANTLR start "definition"
	// Selfish.g:26:1: definition : ( attr )? ( NAME ) ( definitionValue )? {...}? arglist ;
	public final void definition() throws RecognitionException {
		try {
			// Selfish.g:26:12: ( ( attr )? ( NAME ) ( definitionValue )? {...}? arglist )
			// Selfish.g:26:14: ( attr )? ( NAME ) ( definitionValue )? {...}? arglist
			{
			// Selfish.g:26:14: ( attr )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==15) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// Selfish.g:26:15: attr
					{
					pushFollow(FOLLOW_attr_in_definition172);
					attr();
					state._fsp--;

					}
					break;

			}

			// Selfish.g:26:22: ( NAME )
			// Selfish.g:26:23: NAME
			{
			match(input,NAME,FOLLOW_NAME_in_definition177); 
			}

			// Selfish.g:26:29: ( definitionValue )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( ((LA10_0 >= NUMBER && LA10_0 <= STRING)||LA10_0==13||LA10_0==16) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// Selfish.g:26:30: definitionValue
					{
					pushFollow(FOLLOW_definitionValue_in_definition181);
					definitionValue();
					state._fsp--;

					}
					break;

			}

			if ( !((arglist)) ) {
				throw new FailedPredicateException(input, "definition", "arglist");
			}
			pushFollow(FOLLOW_arglist_in_definition187);
			arglist();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "definition"



	// $ANTLR start "definitionValue"
	// Selfish.g:27:1: definitionValue : ( ':' linkReference | literal );
	public final void definitionValue() throws RecognitionException {
		try {
			// Selfish.g:27:17: ( ':' linkReference | literal )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==13) ) {
				alt11=1;
			}
			else if ( ((LA11_0 >= NUMBER && LA11_0 <= STRING)||LA11_0==16) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// Selfish.g:27:19: ':' linkReference
					{
					match(input,13,FOLLOW_13_in_definitionValue197); 
					pushFollow(FOLLOW_linkReference_in_definitionValue199);
					linkReference();
					state._fsp--;

					}
					break;
				case 2 :
					// Selfish.g:27:39: literal
					{
					pushFollow(FOLLOW_literal_in_definitionValue203);
					literal();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "definitionValue"



	// $ANTLR start "linkReference"
	// Selfish.g:28:1: linkReference : ( '/' NAME )+ ;
	public final void linkReference() throws RecognitionException {
		try {
			// Selfish.g:28:15: ( ( '/' NAME )+ )
			// Selfish.g:28:17: ( '/' NAME )+
			{
			// Selfish.g:28:17: ( '/' NAME )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==12) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// Selfish.g:28:19: '/' NAME
					{
					match(input,12,FOLLOW_12_in_linkReference212); 
					match(input,NAME,FOLLOW_NAME_in_linkReference214); 
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "linkReference"



	// $ANTLR start "attr"
	// Selfish.g:29:1: attr : '@' ( NAME | block ) ;
	public final void attr() throws RecognitionException {
		try {
			// Selfish.g:29:7: ( '@' ( NAME | block ) )
			// Selfish.g:29:9: '@' ( NAME | block )
			{
			match(input,15,FOLLOW_15_in_attr226); 
			// Selfish.g:29:13: ( NAME | block )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==NAME) ) {
				alt13=1;
			}
			else if ( (LA13_0==16) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// Selfish.g:29:14: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_attr229); 
					}
					break;
				case 2 :
					// Selfish.g:29:21: block
					{
					pushFollow(FOLLOW_block_in_attr233);
					block();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attr"



	// $ANTLR start "literal"
	// Selfish.g:33:1: literal : ( block | NUMBER | STRING );
	public final void literal() throws RecognitionException {
		try {
			// Selfish.g:33:10: ( block | NUMBER | STRING )
			int alt14=3;
			switch ( input.LA(1) ) {
			case 16:
				{
				alt14=1;
				}
				break;
			case NUMBER:
				{
				alt14=2;
				}
				break;
			case STRING:
				{
				alt14=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// Selfish.g:33:12: block
					{
					pushFollow(FOLLOW_block_in_literal249);
					block();
					state._fsp--;

					}
					break;
				case 2 :
					// Selfish.g:33:20: NUMBER
					{
					match(input,NUMBER,FOLLOW_NUMBER_in_literal253); 
					}
					break;
				case 3 :
					// Selfish.g:33:29: STRING
					{
					match(input,STRING,FOLLOW_STRING_in_literal257); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "literal"



	// $ANTLR start "block"
	// Selfish.g:34:1: block : '{' code '}' ;
	public final void block() throws RecognitionException {
		try {
			// Selfish.g:34:8: ( '{' code '}' )
			// Selfish.g:34:10: '{' code '}'
			{
			match(input,16,FOLLOW_16_in_block266); 
			pushFollow(FOLLOW_code_in_block268);
			code();
			state._fsp--;

			match(input,17,FOLLOW_17_in_block270); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "block"

	// Delegated rules



	public static final BitSet FOLLOW_code_in_start_rule10 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expressionlist_in_code28 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_code31 = new BitSet(new long[]{0x00000000000181E0L});
	public static final BitSet FOLLOW_expressionlist_in_code33 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_expression_in_expressionlist45 = new BitSet(new long[]{0x00000000000185E2L});
	public static final BitSet FOLLOW_10_in_expressionlist49 = new BitSet(new long[]{0x00000000000181E0L});
	public static final BitSet FOLLOW_expression_in_expressionlist53 = new BitSet(new long[]{0x00000000000185E2L});
	public static final BitSet FOLLOW_binaryGroup_in_expression65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dotGroup_in_binaryGroup77 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_BNAME_in_binaryGroup80 = new BitSet(new long[]{0x00000000000181E0L});
	public static final BitSet FOLLOW_dotGroup_in_binaryGroup82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_precedence_in_dotGroup96 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_assoc_in_dotGroup98 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_dotGroup104 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_dotGroup106 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_arglist_in_dotGroup115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_arglist129 = new BitSet(new long[]{0x00000000000181E0L});
	public static final BitSet FOLLOW_expressionlist_in_arglist131 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_arglist133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_precedence141 = new BitSet(new long[]{0x00000000000181E0L});
	public static final BitSet FOLLOW_expressionlist_in_precedence143 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_precedence145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_assoc159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_definition_in_assoc163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attr_in_definition172 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NAME_in_definition177 = new BitSet(new long[]{0x00000000000121C0L});
	public static final BitSet FOLLOW_definitionValue_in_definition181 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_arglist_in_definition187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_definitionValue197 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_linkReference_in_definitionValue199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_definitionValue203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_linkReference212 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NAME_in_linkReference214 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_15_in_attr226 = new BitSet(new long[]{0x0000000000010020L});
	public static final BitSet FOLLOW_NAME_in_attr229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_attr233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_literal249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_literal253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_literal257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_block266 = new BitSet(new long[]{0x00000000000381E0L});
	public static final BitSet FOLLOW_code_in_block268 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_block270 = new BitSet(new long[]{0x0000000000000002L});
}
