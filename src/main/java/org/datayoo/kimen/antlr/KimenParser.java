// $ANTLR 3.5.2 org/datayoo/kimen/antlr/Kimen.g 2024-01-24 11:13:50

package org.datayoo.kimen.antlr;
import java.util.LinkedList;
import org.apache.commons.lang3.Validate;

import org.datayoo.kimen.metadata.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class KimenParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CharSetLiteral", "ConstStringLiteral", 
		"Escape", "NUM", "WS", "','", "'{'", "'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public KimenParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public KimenParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return KimenParser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/datayoo/kimen/antlr/Kimen.g"; }





	// $ANTLR start "kimen"
	// org/datayoo/kimen/antlr/Kimen.g:25:1: kimen returns [KimenMetadata kimenMetadata] : (t= ConstStringLiteral |t= CharSetLiteral (lengthRangeMetadata= lengthRange )? )+ ;
	public final KimenMetadata kimen() throws RecognitionException {
		KimenMetadata kimenMetadata = null;


		Token t=null;
		LengthRangeMetadata lengthRangeMetadata =null;


		    List<CharSetMetadata> metadatas = new LinkedList();

		try {
			// org/datayoo/kimen/antlr/Kimen.g:32:2: ( (t= ConstStringLiteral |t= CharSetLiteral (lengthRangeMetadata= lengthRange )? )+ )
			// org/datayoo/kimen/antlr/Kimen.g:32:4: (t= ConstStringLiteral |t= CharSetLiteral (lengthRangeMetadata= lengthRange )? )+
			{
			// org/datayoo/kimen/antlr/Kimen.g:32:4: (t= ConstStringLiteral |t= CharSetLiteral (lengthRangeMetadata= lengthRange )? )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ConstStringLiteral) ) {
					alt2=1;
				}
				else if ( (LA2_0==CharSetLiteral) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// org/datayoo/kimen/antlr/Kimen.g:32:5: t= ConstStringLiteral
					{
					t=(Token)match(input,ConstStringLiteral,FOLLOW_ConstStringLiteral_in_kimen73); if (state.failed) return kimenMetadata;
					if ( state.backtracking==0 ) {
						        String text = t.getText();
						        text = text.substring(1, text.length()-1);
						        CharSetMetadata charSetMetadata = new CharSetMetadata(text);
						        metadatas.add(charSetMetadata);
						    }
					}
					break;
				case 2 :
					// org/datayoo/kimen/antlr/Kimen.g:38:4: t= CharSetLiteral (lengthRangeMetadata= lengthRange )?
					{
					t=(Token)match(input,CharSetLiteral,FOLLOW_CharSetLiteral_in_kimen84); if (state.failed) return kimenMetadata;
					// org/datayoo/kimen/antlr/Kimen.g:38:43: (lengthRangeMetadata= lengthRange )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==10) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// org/datayoo/kimen/antlr/Kimen.g:38:43: lengthRangeMetadata= lengthRange
							{
							pushFollow(FOLLOW_lengthRange_in_kimen90);
							lengthRangeMetadata=lengthRange();
							state._fsp--;
							if (state.failed) return kimenMetadata;
							}
							break;

					}

					if ( state.backtracking==0 ) {
						    String text = t.getText();
					    	text = text.substring(1, text.length()-1);
					        VariantCharSetMetadata variantCharSetMetadata = new VariantCharSetMetadata(text, lengthRangeMetadata);
					        metadatas.add(variantCharSetMetadata);
						}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					if (state.backtracking>0) {state.failed=true; return kimenMetadata;}
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			if ( state.backtracking==0 ) {
			    kimenMetadata = new KimenMetadata(metadatas);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return kimenMetadata;
	}
	// $ANTLR end "kimen"



	// $ANTLR start "lengthRange"
	// org/datayoo/kimen/antlr/Kimen.g:46:1: lengthRange returns [LengthRangeMetadata lengthRangeMetadata] : '{' min= NUM ( ',' max= NUM )? '}' ;
	public final LengthRangeMetadata lengthRange() throws RecognitionException {
		LengthRangeMetadata lengthRangeMetadata = null;


		Token min=null;
		Token max=null;

		try {
			// org/datayoo/kimen/antlr/Kimen.g:47:5: ( '{' min= NUM ( ',' max= NUM )? '}' )
			// org/datayoo/kimen/antlr/Kimen.g:47:7: '{' min= NUM ( ',' max= NUM )? '}'
			{
			match(input,10,FOLLOW_10_in_lengthRange113); if (state.failed) return lengthRangeMetadata;
			min=(Token)match(input,NUM,FOLLOW_NUM_in_lengthRange119); if (state.failed) return lengthRangeMetadata;
			// org/datayoo/kimen/antlr/Kimen.g:47:21: ( ',' max= NUM )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==9) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// org/datayoo/kimen/antlr/Kimen.g:47:22: ',' max= NUM
					{
					match(input,9,FOLLOW_9_in_lengthRange122); if (state.failed) return lengthRangeMetadata;
					max=(Token)match(input,NUM,FOLLOW_NUM_in_lengthRange128); if (state.failed) return lengthRangeMetadata;
					}
					break;

			}

			match(input,11,FOLLOW_11_in_lengthRange132); if (state.failed) return lengthRangeMetadata;
			if ( state.backtracking==0 ) {
			        if (max != null) {
			            lengthRangeMetadata = new LengthRangeMetadata(Integer.valueOf(min.getText()), Integer.valueOf(max.getText()));
			        } else {
			            lengthRangeMetadata = new LengthRangeMetadata(Integer.valueOf(min.getText()), Integer.valueOf(min.getText()));
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
		return lengthRangeMetadata;
	}
	// $ANTLR end "lengthRange"

	// Delegated rules



	public static final BitSet FOLLOW_ConstStringLiteral_in_kimen73 = new BitSet(new long[]{0x0000000000000032L});
	public static final BitSet FOLLOW_CharSetLiteral_in_kimen84 = new BitSet(new long[]{0x0000000000000432L});
	public static final BitSet FOLLOW_lengthRange_in_kimen90 = new BitSet(new long[]{0x0000000000000032L});
	public static final BitSet FOLLOW_10_in_lengthRange113 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUM_in_lengthRange119 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_9_in_lengthRange122 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NUM_in_lengthRange128 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_lengthRange132 = new BitSet(new long[]{0x0000000000000002L});
}
