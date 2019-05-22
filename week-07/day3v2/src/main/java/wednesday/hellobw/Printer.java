package wednesday.hellobw;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Printer {
  public void log(String message, MyColor mycolor) {
    System.out.print(LocalDateTime.now() + " MY PRINTER SAYS --- ");
    mycolor.printColor();
  }
}
