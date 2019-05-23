package com.myfox.myfox.controller;

import com.myfox.myfox.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
  List<Fox> myFoxes = new ArrayList<>();

  @GetMapping("/")
  public String index (@RequestParam (name = "name", required = false) String name, Model model) {

    if (name == null) {
      return "login";
    } else {
      myFoxes.add(new Fox(name));
      model.addAttribute("name", name);
      model.addAttribute("nrOfTricks", myFoxes.get(myFoxes.size() - 1).getTricks().size());
      model.addAttribute("listOfTricks", myFoxes.get(myFoxes.size() - 1).getTricks());
      model.addAttribute("listOfFoods", myFoxes.get(myFoxes.size() - 1).getDiet());
      model.addAttribute("food", myFoxes.get(myFoxes.size() - 1).getDiet()[0]);
      model.addAttribute("drink", myFoxes.get(myFoxes.size() - 1).getDiet()[1]);

      return "index";
    }
  }


  @GetMapping("/login")
  public String login () {
    return "login";
  }

  @PostMapping("/login")
  public String namePet (String name) {
    return "redirect:/?name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String diet (String food, String drink){
    myFoxes.get(myFoxes.size() - 1).getDiet()[0] = food;
    myFoxes.get(myFoxes.size() - 1).getDiet()[1] = drink;
    System.out.println(myFoxes.get(myFoxes.size() - 1).getDiet()[0]);
    System.out.println(myFoxes.get(myFoxes.size() - 1).getDiet()[1]);
    return "redirect:/?name=" + myFoxes.get(myFoxes.size() - 1).getName();

  }

  @GetMapping("/nutritionStore")
  public String eat () {
    return "nutritionStore";
  }
}
