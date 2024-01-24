package org.datayoo.kimen.core;

import org.apache.commons.lang3.Validate;
import org.datayoo.kimen.metadata.CharSetMetadata;
import org.datayoo.kimen.metadata.KimenMetadata;
import org.datayoo.kimen.metadata.VariantCharSetMetadata;

import java.util.LinkedList;
import java.util.List;

public class KimenExpression implements StringGenerator {

  protected List<StringGenerator> stringGenerators = new LinkedList<StringGenerator>();

  public KimenExpression(KimenMetadata kimenMetadata,
      CharSetManagable charSetManagable) {
    Validate.notNull(kimenMetadata, "kimenMetadata is null!");
    Validate.notNull(charSetManagable, "charSetManagable is null!");
    buildStringGenerators(kimenMetadata.getCharSetMetadatas(),
        charSetManagable);
  }

  protected void buildStringGenerators(List<CharSetMetadata> charSetMetadatas,
      CharSetManagable charSetManagable) {
    for (CharSetMetadata charSetMetadata : charSetMetadatas) {
      if (charSetMetadata instanceof VariantCharSetMetadata) {
        stringGenerators.add(
            new VariantStringGenerator((VariantCharSetMetadata) charSetMetadata,
                charSetManagable));
      } else {
        stringGenerators.add(new ConstantStringGenerator(charSetMetadata));
      }
    }
  }

  public String generate() {
    StringBuilder sbud = new StringBuilder();
    for (StringGenerator stringGenerator : stringGenerators) {
      sbud.append(stringGenerator.generate());
    }
    return sbud.toString();
  }
}
