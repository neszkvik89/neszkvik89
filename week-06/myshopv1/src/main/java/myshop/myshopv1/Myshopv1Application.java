package myshop.myshopv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Myshopv1Application {

  public static void main(String[] args) {
    SpringApplication.run(Myshopv1Application.class, args);
  }

  @RequestMapping
  @ResponseBody
  public String hello () {
    return "Hello World!";
  }
}
