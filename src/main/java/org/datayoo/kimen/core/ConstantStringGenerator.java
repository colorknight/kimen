package org.datayoo.kimen.core;

import org.apache.commons.lang3.Validate;
import org.datayoo.kimen.metadata.CharSetMetadata;

public class ConstantStringGenerator implements StringGenerator {

  protected CharSetMetadata charSetMetadata;

  public ConstantStringGenerator(CharSetMetadata charSetMetadata) {
    Validate.notNull(charSetMetadata, "charSetMetadata is null!");
    this.charSetMetadata = charSetMetadata;
  }

  public String generate() {
    return charSetMetadata.getCharSet();
  }

}
