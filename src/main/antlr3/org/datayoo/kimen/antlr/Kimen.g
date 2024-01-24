grammar Kimen;

options {
language = Java;
backtrack=true;
}

tokens {
}
 
@header {
package org.datayoo.kimen.antlr;
import java.util.LinkedList;
import org.apache.commons.lang3.Validate;

import org.datayoo.kimen.metadata.*;
}
@lexer::header {
package org.datayoo.kimen.antlr;
}

@members {
}
	
kimen returns[KimenMetadata kimenMetadata]
@init {
    List<CharSetMetadata> metadatas = new LinkedList();
}
@after {
    kimenMetadata = new KimenMetadata(metadatas);
}
	: (t = ConstStringLiteral {
	        String text = t.getText();
	        text = text.substring(1, text.length()-1);
	        CharSetMetadata charSetMetadata = new CharSetMetadata(text);
	        metadatas.add(charSetMetadata);
	    }
	| t = CharSetLiteral lengthRangeMetadata = lengthRange ? {
	    String text = t.getText();
    	text = text.substring(1, text.length()-1);
        VariantCharSetMetadata variantCharSetMetadata = new VariantCharSetMetadata(text, lengthRangeMetadata);
        metadatas.add(variantCharSetMetadata);
	})+
	;

lengthRange returns[LengthRangeMetadata lengthRangeMetadata]
    : '{' min = NUM (',' max = NUM)? '}' {
        if (max != null) {
            lengthRangeMetadata = new LengthRangeMetadata(Integer.valueOf(min.getText()), Integer.valueOf(max.getText()));
        } else {
            lengthRangeMetadata = new LengthRangeMetadata(Integer.valueOf(min.getText()), Integer.valueOf(min.getText()));
        }
    }
    ;

//Lexer

ConstStringLiteral
    :  '\'' ( ~'\'' | Escape)*  '\''
    |  '"' (~'"' | '\\"')* '"'
    ;

CharSetLiteral
    :  '[' ( ~('['|']'))+  ']'
    ;

NUM
    : ('1'..'9') ('0'..'9')*
    ;

fragment
Escape	: '\'' '\'';

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;
