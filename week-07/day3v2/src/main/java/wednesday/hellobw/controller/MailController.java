package wednesday.hellobw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

  private UtilityService utilityService;


  @Autowired
  MailController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful/email")
  public String email(Model model) {
    return "email";
  }

  @PostMapping ("/useful/email")
  public String printResult(@RequestParam("email") int email, Model model){
    return "email";
  }
}

