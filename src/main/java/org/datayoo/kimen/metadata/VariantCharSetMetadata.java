package org.datayoo.kimen.metadata;

import org.apache.commons.lang3.Validate;

public class VariantCharSetMetadata extends CharSetMetadata {
  protected LengthRangeMetadata lengthRangeMetadata;

  public VariantCharSetMetadata(String charSet,
      LengthRangeMetadata lengthRangeMetadata) {
    super(charSet);
    Validate.notNull(lengthRangeMetadata, "lengthRangeMetadata is null!");
    this.lengthRangeMetadata = lengthRangeMetadata;
  }

  public LengthRangeMetadata getLengthRangeMetadata() {
    return lengthRangeMetadata;
  }
}
