import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class api {
  public static void main(String[] args) {
    // 1 Arrays toString方法 将数组转换为一个字符串输出
    String[] name = {"ricky","duran","bonhiver"};
    System.out.println(Arrays.toString(name));
    // 2 Arrays asList方法 传入一个数组，返回一个List集合
    List<String> list = Arrays.asList("a","b","c");
    System.out.println(list);
    // 3
    Collections.sort(list);
  }
}
