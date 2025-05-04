public class Lambda_Expressions {
  public static void main(String[] args) {
    sendMessage(() -> System.out.println("Testing Lambda Expressions!"));
  }

  public static void sendMessage(send s)
  {
    s.sendMessage();
  }
}

interface send{
  public void sendMessage();
}

