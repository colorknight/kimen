package org.datayoo.kimen.core;

import org.apache.commons.lang3.Validate;
import org.datayoo.kimen.metadata.LengthRangeMetadata;
import org.datayoo.kimen.metadata.VariantCharSetMetadata;

public class VariantStringGenerator implements StringGenerator {

  public static final char[] reservedChars = new char[] { 'b', 't', 'r', 'n'
  };

  public static final char[] escapedChars = new char[] { '\b', '\t', '\r', '\n'
  };

  protected char[] charSequences;

  protected int minLength;

  protected int maxLength;

  protected int diff = 0;

  public VariantStringGenerator(VariantCharSetMetadata variantCharSetMetadata,
      CharSetManagable charSetManagable) {
    Validate.notNull(variantCharSetMetadata, "variantCharSetMetadata is null!");
    Validate.notNull(charSetManagable, "charSetManagable is null!");

    charSequences = buildCharSequences(variantCharSetMetadata.getCharSet(),
        charSetManagable);
    LengthRangeMetadata lengthRangeMetadata = variantCharSetMetadata.getLengthRangeMetadata();
    this.minLength = lengthRangeMetadata.getMinLength();
    this.maxLength = lengthRangeMetadata.getMaxLength();
    diff = maxLength - minLength;
  }

  public char getReservedChar(char ch) {
    for (int i = 0; i < reservedChars.length; i++) {
      if (ch == reservedChars[i])
        return escapedChars[i];
    }
    return 0;
  }

  protected char[] buildCharSequences(String charSet,
      CharSetManagable charSetManagable) {
    StringBuilder sbud = new StringBuilder();
    char prev = 0;
    boolean escape = false;
    boolean range = false;
    for (char ch : charSet.toCharArray()) {
      if (ch == '\\' && !escape) {
        escape = true;
      } else if (ch == '-') {
        range = true;
        continue;
      } else if (escape) {
        if (ch == '\\') {
          sbud.append(ch);
        } else {
          char escapedChar = getReservedChar(ch);
          if (escapedChar != 0)
            sbud.append(escapedChar);
          else
            sbud.append(charSetManagable.getCharSet(ch));
        }
        escape = false;
      } else if (range) {
        // a-z
        while (prev < ch) {
          char c = ++prev;
          if (hasChar(sbud, c))
            continue;
          sbud.append(c);
        }
        sbud.append(ch);
        range = false;
      } else {
        sbud.append(ch);
      }
      prev = ch;
    }
    char[] chars = new char[sbud.length()];
    sbud.getChars(0, sbud.length(), chars, 0);
    return chars;
  }

  protected boolean hasChar(StringBuilder sbud, char ch) {
    int inx = sbud.indexOf(new String(new char[] { ch }));
    if (inx == -1)
      return false;
    return true;
  }

  public String generate() {
    int length = getRandomLength();
    char[] genChars = new char[length];
    for (int i = 0; i < length; i++) {
      genChars[i] = charSequences[getRandomIndex()];
    }
    return new String(genChars);
  }

  protected int getRandomIndex() {
    return (int) (System.nanoTime() % charSequences.length);
  }

  protected int getRandomLength() {
    if (diff == 0)
      return minLength;
    return (int) (System.nanoTime() % diff + minLength);
  }
}
