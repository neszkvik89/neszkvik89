package bankaccount.simba.controllers;

import bankaccount.simba.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {
  BankAccount myBankAccount = new BankAccount("Simba", 2000, "lion");

  @GetMapping("/show")
  public String show(Model model) {

    model.addAttribute("myBankAccount", myBankAccount);
    return "show";
  }
}
