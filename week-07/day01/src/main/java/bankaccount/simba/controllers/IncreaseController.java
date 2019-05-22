package bankaccount.simba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class IncreaseController {

  @GetMapping("/increase")
  public String increase(Model model) {
    model.addAttribute("bankAccounts", ListController.bankAccounts);
    return "increase";
  }


}
