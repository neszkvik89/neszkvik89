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
  static List<Fox> myFoxes = new ArrayList<>();

  @GetMapping("/")
  public String index (@RequestParam (name = "name", required = false) String name,
                       @RequestParam (name = "food", required = false) String food,
                       @RequestParam (name = "drink", required = false) String drink,
                       @RequestParam (name = "trick", required = false) String trick, Model model) {

    if (name == null && food == null && trick == null) {
      return "login";
    } else if (food == null && trick == null){
      myFoxes.add(new Fox(name));
    }
      model.addAttribute("name", myFoxes.get(myFoxes.size() - 1).getName());
      model.addAttribute("nrOfTricks", myFoxes.get(myFoxes.size() - 1).getTricks().size());
      model.addAttribute("listOfTricks", myFoxes.get(myFoxes.size() - 1).getTricks());
      model.addAttribute("listOfFoods", myFoxes.get(myFoxes.size() - 1).getDiet());
      model.addAttribute("food", myFoxes.get(myFoxes.size() - 1).getDiet()[0]);
      model.addAttribute("drink", myFoxes.get(myFoxes.size() - 1).getDiet()[1]);
    System.out.println(model.asMap());

      return "index";
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
    return "redirect:/?name=" + myFoxes.get(myFoxes.size() - 1).getName() + "&?food=" + food + "&?drink=" + drink;
  }

  @PostMapping("/trickCenter")
  public String learnTrick(String trick) {
    if (!myFoxes.get(myFoxes.size() - 1).getTricks().contains(trick)) {
      myFoxes.get(myFoxes.size() - 1).getTricks().add(trick);
    }
    return "redirect:/?trick=" + trick + "&?food=" + myFoxes.get(myFoxes.size() - 1).getDiet()[0] + "&?drink="
            + myFoxes.get(myFoxes.size() - 1).getDiet()[1] + "&?name=" + myFoxes.get(myFoxes.size() - 1).getName();
  }

  @GetMapping("/nutritionStore")
  public String eat () {
    return "nutritionStore";
  }

  @GetMapping("/trickCenter")
  public String trick() {

    return "trickCenter";
  }
}
