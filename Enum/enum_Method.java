package Enum;

/**
 *  about: 枚举  关键词：enum
 *  motivation: 可以看成是一种特殊的类 构造器必须私有 单例设计模式 实例必须在字段和方法之前
 *  枚举无法继承 因为它继承自Enum类 而Java属于单继承
 *  https://www.cnblogs.com/jingmoxukong/p/6098351.html
 */

public class enum_Method {
  enum Color {RED, GREEN, BLUE;}
  enum Size {BIG, MIDDLE, SMALL;}
  public static void main(String args[]) {
      System.out.println("=========== Print all Color ===========");
      for (Color c : Color.values()) {
          System.out.println(c + " ordinal: " + c.ordinal());
      }
      System.out.println("=========== Print all Size ===========");
      for (Size s : Size.values()) {
          System.out.println(s + " ordinal: " + s.ordinal());
      }

      Color green = Color.GREEN;
      System.out.println("green name(): " + green.name());
      System.out.println("green getDeclaringClass(): " + green.getDeclaringClass());
      System.out.println("green hashCode(): " + green.hashCode());
      System.out.println("green compareTo Color.GREEN: " + green.compareTo(Color.GREEN));
      System.out.println("green equals Color.GREEN: " + green.equals(Color.GREEN));
      System.out.println("green equals Size.MIDDLE: " + green.equals(Size.MIDDLE));
      System.out.println("green equals 1: " + green.equals(1));
      System.out.format("green == Color.BLUE: %b\n", green == Color.BLUE);
  }
}




