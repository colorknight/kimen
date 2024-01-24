package org.datayoo.kimen.core;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.commons.lang3.Validate;
import org.datayoo.kimen.antlr.KimenLexer;
import org.datayoo.kimen.antlr.KimenParser;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class KimenBuilder implements CharSetManagable {

  protected Map<Character, String> charSetDictionaries = new HashMap();

  public String getCharSet(char dictionary) {
    return charSetDictionaries.get(dictionary);
  }

  public void addCharSet(char dictionary, String charSet) {
    Validate.notEmpty(charSet, "charSet is empty!");
    charSetDictionaries.put(dictionary, charSet);
  }

  public StringGenerator buildKimen(String expression) {
    Validate.notEmpty(expression, "expression is empty!");
    try {
      ANTLRInputStream is = new ANTLRInputStream(
          new ByteArrayInputStream(expression.getBytes()));
      KimenLexer lexer = new KimenLexer(is);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      KimenParser parser = new KimenParser(tokens);
      return new KimenExpression(parser.kimen(), this);
    } catch (Exception e) {
      throw new IllegalArgumentException(
          String.format("Parse expression '%s' failed!", expression), e);
    }
  }
}
