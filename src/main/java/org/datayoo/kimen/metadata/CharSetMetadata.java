package org.datayoo.kimen.metadata;

import org.apache.commons.lang3.Validate;

import java.io.Serializable;

public class CharSetMetadata implements Serializable {

  protected String charSet;

  public CharSetMetadata(String charSet) {
    Validate.notEmpty(charSet, "charSet is empty!");
    this.charSet = charSet;
  }

  public String getCharSet() {
    return charSet;
  }
}
