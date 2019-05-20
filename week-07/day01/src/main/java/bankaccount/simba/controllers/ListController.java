package bankaccount.simba.controllers;

import bankaccount.simba.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {
  public static List<BankAccount> bankAccounts = new ArrayList();

  @GetMapping ("/list")
  public String list (Model model) {
    bankAccounts.add(new BankAccount("Pumba", 1500, "Pig", false, true));
    bankAccounts.add(new BankAccount("Timon", 2200, "Rat", false, true));
    bankAccounts.add(new BankAccount("Mufasa", 700, "Monkey", false, true));
    bankAccounts.add(new BankAccount("Scar", 3100, "Lion", false, false));
    bankAccounts.add(new BankAccount("Simba", 2900, "Lion", true, true));
    bankAccounts.add(new BankAccount("Attila", 4400, "Human", true, true));

    model.addAttribute("bankAccounts", bankAccounts);
    return "list";
  }
}
