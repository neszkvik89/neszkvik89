package com.myfox.myfox.controller;

import com.myfox.myfox.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


  @GetMapping("/")
  public String index(@RequestParam(name = "name", required = false) String name,
                      @RequestParam(name = "food", required = false) String food,
                      @RequestParam(name = "drink", required = false) String drink,
                      @RequestParam(name = "trick", required = false) String trick, Model model) {

    if (name == null && food == null && trick == null) {
      return "login";
    } else if (Fox.myFoxes.size() == 0) {
      Fox.myFoxes.add(new Fox(name));
    }

    modelUpdate(model);

    return "index";
  }


  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String namePet(String name) {
    return "redirect:/?name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String diet(String food, String drink) {
    Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[0] = food;
    Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[1] = drink;
    System.out.println(Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[0]);
    System.out.println(Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[1]);
    return "redirect:/?name=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName() + "&?food=" + food + "&?drink=" + drink;
  }

  @PostMapping("/trickCenter")
  public String learnTrick(String trick) {
    if (!Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks().contains(trick)) {
      Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks().add(trick);
      Fox.myFoxes.get(Fox.myFoxes.size() - 1).getAvailableTricks().remove(trick);
    }
    return "redirect:/?trick=" + trick + "&?food=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[0] + "&?drink="
            + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[1] + "&?name=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName();
  }

  @GetMapping("/nutritionStore")
  public String eat(Model model) {
    modelUpdate(model);
    return "nutritionStore";
  }

  @GetMapping("/trickCenter")
  public String trick(Model model) {
    modelUpdate(model);
    return "trickCenter";
  }

  @ModelAttribute
  public void modelUpdate(Model model) {
    if (Fox.myFoxes.size() != 0) {
      model.addAttribute("name", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName());
      model.addAttribute("nrOfTricks", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks().size());
      model.addAttribute("listOfTricks", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks());
      model.addAttribute("listOfFoods", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet());
      model.addAttribute("food", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[0]);
      model.addAttribute("drink", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[1]);
      model.addAttribute("availableTricks", Fox.myFoxes.get(Fox.myFoxes.size() - 1).getAvailableTricks());
    }
  }
}
