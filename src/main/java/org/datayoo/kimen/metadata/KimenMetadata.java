package org.datayoo.kimen.metadata;

import org.apache.commons.lang3.Validate;

import java.util.LinkedList;
import java.util.List;

public class KimenMetadata {
  protected List<CharSetMetadata> charSetMetadatas = new LinkedList<CharSetMetadata>();

  public KimenMetadata(List<CharSetMetadata> charSetMetadatas) {
    Validate.notEmpty(charSetMetadatas, "charSetMetadatas is empty!");

    this.charSetMetadatas = charSetMetadatas;
  }

  public List<CharSetMetadata> getCharSetMetadatas() {
    return charSetMetadatas;
  }
}
