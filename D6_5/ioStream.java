package D6_5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * java IO流操作 https://www.cnblogs.com/baixl/p/4170599.html
 */
public class ioStream {
  public static void main(String[] args) {
    // 1 文件 File类
    File dir1 = new File("C:/Users/rickyduran/Desktop/Java_Daily_Learning/java_learning/D6_5/test");
    if (!dir1.exists())
      dir1.mkdirs();
    System.out.println(dir1.getAbsolutePath());

    // 2 IO流 用处处理设备之间的数据传输
    // 抽象基类 字节流 字符流
    // 输入流 InputStream Reader
    // 输出流 OutputStream Writer

    // 文件流
    try {
      FileWriter fw = new FileWriter("Test.txt");
      fw.write("suck my dick");
      fw.close();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    try {
      FileReader fr = new FileReader("C:/Users/rickyduran/Desktop/Java_Daily_Learning/Test.txt");
      char[] buf = new char[1024];
      int len = 0;
      while ((len = fr.read(buf)) != -1) {
        System.out.println(new String(buf, 0, len));
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
