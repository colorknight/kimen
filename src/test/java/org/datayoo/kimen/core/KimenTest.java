package org.datayoo.kimen.core;

import junit.framework.TestCase;

public class KimenTest extends TestCase {

  public void testExpression1() {
    // 基本表达式
    String expr = "[a-zA-Z]{4}'1234'[a-zA-Z]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
  }

  public void testExpression2() {
    String expr = "[a-zA-Z]{4}'1234'[a-zA-Z]{4,8}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
  }

  public void testExpression3() {
    // 常量字符串转义字符
    String expr = "[a-zA-Z]{4}'1234\\'[a-zA-Z]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    System.out.println(stringGenerator.generate());
    // 双引号字符串
    expr = "[a-zA-Z]{4}\"1234\"[a-zA-Z]{4}";
    kimenBuilder = new KimenBuilder();
    stringGenerator = kimenBuilder.buildKimen(expr);
    System.out.println(stringGenerator.generate());
  }

  public void testExpression4() {
    // 变化字符串转义字符
    String expr = "[a-zA-Z]{4}\"1234\"[a\\\\]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
  }

  public void testExpression5() {
    // 转义字符字典
    String expr = "[a-zA-Z]{4}\"1234\"[\\a123]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    kimenBuilder.addCharSet('a',"bcd");
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
  }

  public void testExpression6() {
    // 转义字符字典
    String expr = "[a-zA-Z]{4}\"1234\"[\\a\\d]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    kimenBuilder.addCharSet('a',"bcd");
    kimenBuilder.addCharSet('d',"123");
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
  }
}
