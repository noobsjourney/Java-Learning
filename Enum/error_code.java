package Enum;

/**
 *  about: error_code 一个标准的错误码枚举类
 */

public enum error_code{
  OK(0, "成功"),
  ERROR_A(100, "错误A"),
  ERROR_B(200, "错误B");

  error_code(int number, String description) {
      this.code = number;
      this.description = description;
  }
  private int code;
  private String description;
  public int getCode() {
      return code;
  }
  public String getDescription() {
      return description;
  }
  public static void main(String args[]) { // 静态方法
      for (error_code s : error_code.values()) {
          System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
      }
  }
}