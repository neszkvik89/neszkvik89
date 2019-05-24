package com.myfox.myfox.controller;

import com.myfox.myfox.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.sql.Timestamp;


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
      Fox.actionsTaken.add(getTimeStamp() + " " + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName()
              + " is the name of your new fox!");
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
    Fox.actionsTaken.add(getTimeStamp() + " " + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName()
            + " now eats " + food
            + " and drinks " + drink);
    return "redirect:/?name=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName()
            + "&?food=" + food + "&?drink=" + drink;
  }

  @PostMapping("/trickCenter")
  public String learnTrick(String trick) {
    if (!Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks().contains(trick)) {
      Fox.myFoxes.get(Fox.myFoxes.size() - 1).getTricks().add(trick);
      Fox.myFoxes.get(Fox.myFoxes.size() - 1).getAvailableTricks().remove(trick);
      Fox.actionsTaken.add(getTimeStamp() + " " + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName()
              + " learned " + trick);
      updateLatestActionList();
    }
    return "redirect:/?trick=" + trick + "&?food=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[0] + "&?drink="
            + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getDiet()[1] + "&?name="
            + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName();
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

  @GetMapping("/actionHistory")
  public String actions(Model model) {
    modelUpdate(model);
    return "actionHistory";
  }

  public Timestamp getTimeStamp() {
    Date date = new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    return ts;
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
      model.addAttribute("actionHistory", Fox.actionsTaken);
      model.addAttribute("latestActions", Fox.latestActions);
    }
  }

  public void updateLatestActionList() {
    for (int i = 0; i < 5; i++) {
      if (Fox.actionsTaken.size() > i) {
        Fox.latestActions[i] = Fox.actionsTaken.get(Fox.actionsTaken.size() - i - 1);
      }
    }
  }
}
