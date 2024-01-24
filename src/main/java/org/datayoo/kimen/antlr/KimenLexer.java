// $ANTLR 3.5.2 org/datayoo/kimen/antlr/Kimen.g 2024-01-24 11:13:50

package org.datayoo.kimen.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class KimenLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int CharSetLiteral=4;
	public static final int ConstStringLiteral=5;
	public static final int Escape=6;
	public static final int NUM=7;
	public static final int WS=8;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public KimenLexer() {} 
	public KimenLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public KimenLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "org/datayoo/kimen/antlr/Kimen.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:11:6: ( ',' )
			// org/datayoo/kimen/antlr/Kimen.g:11:8: ','
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:12:7: ( '{' )
			// org/datayoo/kimen/antlr/Kimen.g:12:9: '{'
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:13:7: ( '}' )
			// org/datayoo/kimen/antlr/Kimen.g:13:9: '}'
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
	// $ANTLR end "T__11"

	// $ANTLR start "ConstStringLiteral"
	public final void mConstStringLiteral() throws RecognitionException {
		try {
			int _type = ConstStringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:59:5: ( '\\'' (~ '\\'' | Escape )* '\\'' | '\"' (~ '\"' | '\\\\\"' )* '\"' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\'') ) {
				alt3=1;
			}
			else if ( (LA3_0=='\"') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// org/datayoo/kimen/antlr/Kimen.g:59:8: '\\'' (~ '\\'' | Escape )* '\\''
					{
					match('\''); 
					// org/datayoo/kimen/antlr/Kimen.g:59:13: (~ '\\'' | Escape )*
					loop1:
					while (true) {
						int alt1=3;
						int LA1_0 = input.LA(1);
						if ( (LA1_0=='\'') ) {
							int LA1_1 = input.LA(2);
							if ( (LA1_1=='\'') ) {
								alt1=2;
							}

						}
						else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '&')||(LA1_0 >= '(' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// org/datayoo/kimen/antlr/Kimen.g:59:15: ~ '\\''
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;
						case 2 :
							// org/datayoo/kimen/antlr/Kimen.g:59:23: Escape
							{
							mEscape(); 

							}
							break;

						default :
							break loop1;
						}
					}

					match('\''); 
					}
					break;
				case 2 :
					// org/datayoo/kimen/antlr/Kimen.g:60:8: '\"' (~ '\"' | '\\\\\"' )* '\"'
					{
					match('\"'); 
					// org/datayoo/kimen/antlr/Kimen.g:60:12: (~ '\"' | '\\\\\"' )*
					loop2:
					while (true) {
						int alt2=3;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='\\') ) {
							int LA2_2 = input.LA(2);
							if ( (LA2_2=='\"') ) {
								int LA2_4 = input.LA(3);
								if ( ((LA2_4 >= '\u0000' && LA2_4 <= '\uFFFF')) ) {
									alt2=2;
								}
								else {
									alt2=1;
								}

							}
							else if ( ((LA2_2 >= '\u0000' && LA2_2 <= '!')||(LA2_2 >= '#' && LA2_2 <= '\uFFFF')) ) {
								alt2=1;
							}

						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// org/datayoo/kimen/antlr/Kimen.g:60:13: ~ '\"'
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
						case 2 :
							// org/datayoo/kimen/antlr/Kimen.g:60:20: '\\\\\"'
							{
							match("\\\""); 

							}
							break;

						default :
							break loop2;
						}
					}

					match('\"'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ConstStringLiteral"

	// $ANTLR start "CharSetLiteral"
	public final void mCharSetLiteral() throws RecognitionException {
		try {
			int _type = CharSetLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:64:5: ( '[' (~ ( '[' | ']' ) )+ ']' )
			// org/datayoo/kimen/antlr/Kimen.g:64:8: '[' (~ ( '[' | ']' ) )+ ']'
			{
			match('['); 
			// org/datayoo/kimen/antlr/Kimen.g:64:12: (~ ( '[' | ']' ) )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= 'Z')||LA4_0=='\\'||(LA4_0 >= '^' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// org/datayoo/kimen/antlr/Kimen.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
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

			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CharSetLiteral"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:68:5: ( ( '1' .. '9' ) ( '0' .. '9' )* )
			// org/datayoo/kimen/antlr/Kimen.g:68:7: ( '1' .. '9' ) ( '0' .. '9' )*
			{
			if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// org/datayoo/kimen/antlr/Kimen.g:68:18: ( '0' .. '9' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// org/datayoo/kimen/antlr/Kimen.g:
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
					break loop5;
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
	// $ANTLR end "NUM"

	// $ANTLR start "Escape"
	public final void mEscape() throws RecognitionException {
		try {
			// org/datayoo/kimen/antlr/Kimen.g:73:8: ( '\\'' '\\'' )
			// org/datayoo/kimen/antlr/Kimen.g:73:10: '\\'' '\\''
			{
			match('\''); 
			match('\''); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Escape"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// org/datayoo/kimen/antlr/Kimen.g:74:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// org/datayoo/kimen/antlr/Kimen.g:74:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// org/datayoo/kimen/antlr/Kimen.g:1:8: ( T__9 | T__10 | T__11 | ConstStringLiteral | CharSetLiteral | NUM | WS )
		int alt6=7;
		switch ( input.LA(1) ) {
		case ',':
			{
			alt6=1;
			}
			break;
		case '{':
			{
			alt6=2;
			}
			break;
		case '}':
			{
			alt6=3;
			}
			break;
		case '\"':
		case '\'':
			{
			alt6=4;
			}
			break;
		case '[':
			{
			alt6=5;
			}
			break;
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
			alt6=6;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt6=7;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// org/datayoo/kimen/antlr/Kimen.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// org/datayoo/kimen/antlr/Kimen.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// org/datayoo/kimen/antlr/Kimen.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// org/datayoo/kimen/antlr/Kimen.g:1:27: ConstStringLiteral
				{
				mConstStringLiteral(); 

				}
				break;
			case 5 :
				// org/datayoo/kimen/antlr/Kimen.g:1:46: CharSetLiteral
				{
				mCharSetLiteral(); 

				}
				break;
			case 6 :
				// org/datayoo/kimen/antlr/Kimen.g:1:61: NUM
				{
				mNUM(); 

				}
				break;
			case 7 :
				// org/datayoo/kimen/antlr/Kimen.g:1:65: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
