package org.datayoo.kimen.metadata;

import org.apache.commons.lang3.Validate;

import java.io.Serializable;

public class LengthRangeMetadata implements Serializable {
  protected int minLength = 0;

  protected int maxLength = 0;

  public LengthRangeMetadata(int length) {
    Validate.isTrue(length > 0, "length should not less than 1!");
    minLength = maxLength = length;
  }

  public LengthRangeMetadata(int minLength, int maxLength) {
    Validate.isTrue(minLength > 0, "minlength should not less than 1!");
    Validate.isTrue(maxLength > 0, "maxlength should not less than 1!");
    Validate.isTrue(minLength <= maxLength,
        "minLength should less than maxLength!");
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

  public int getMinLength() {
    return minLength;
  }

  public int getMaxLength() {
    return maxLength;
  }

}
