package wednesday.hellobw;

import org.springframework.stereotype.Service;


public class RedColor implements MyColor {
  private String message = "It is red in color...";

  public String getMessage() {
    return message;
  }

  @Override
  public void printColor() {
    System.out.println("It is red in color...");
  }
}
