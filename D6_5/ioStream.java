package D6_5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 *    java IO流操作 https://www.cnblogs.com/baixl/p/4170599.html
 *    关于javaIO流的介绍包括ACM模式下的输入输出模板
 *    缓冲流/转换流/标准输入输出流 这几个比较关键
 */
public class ioStream{
  public static void main(String[] args) throws IOException{
    // 1 文件 File类
    File dir1 = new File("C:/Users/rickyduran/Desktop/Java_Daily_Learning/java_learning/D6_5/test");
    if (!dir1.exists())
      dir1.mkdirs();
    System.out.println(dir1.getAbsolutePath());

    // 2 IO流 用处处理设备之间的数据传输
    // 抽象基类 字节流 字符流
    // 输入流 InputStream Reader
    // 输出流 OutputStream Writer

    // 文件流 写文件/读文件
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
    // 缓冲流 对读写数据提供缓冲功能 提高读写效率 BufferedReader/BufferedWriter
    // 转换流 提供了在字节流和字符流之间的转换 InputStreamReader/InputStreamWriter
    // 标准输入输出流 System.in/System.out 其实是字节流
    // 打印流 PrintStream/PrintWriter


    // ACM模式模板
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int t = (int) in.nval;
			for (int i = 0; i < t; i++) {
				in.nextToken();
				int n = (int) in.nval;
				in.nextToken();
				int m = (int) in.nval;
				for (int j = 0; j < n; j++) {
					in.nextToken();
          // action
					in.nextToken();
					// action
				}
			}
		}
		out.flush();
		br.close();
		out.close();
	}
}
