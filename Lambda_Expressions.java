public class Lambda_Expressions {
  public static void main(String[] args) {
    // 1 创建类继承函数式接口并调用sendMessage方法
    send s = new ZhouHao();
    s.sendMessage("Zhou Hao");
    // 2 使用匿名内部类
    sendMessage(new send() {
      @Override
      public void sendMessage(String s) {
       System.out.println(s); 
      }
    });
    // 3 使用Lambda表达式，简化了匿名内部类的写法
    sendMessage((message) -> System.out.println(message));
  }

  public static void sendMessage(send s)
  {
    s.sendMessage("Testing Lambad operations!");
  }
}

interface send{
  public void sendMessage(String s);
}

class ZhouHao implements send{
  @Override
  public void sendMessage(String s) {
    System.out.println("This is from " + s + "!");
  }
}