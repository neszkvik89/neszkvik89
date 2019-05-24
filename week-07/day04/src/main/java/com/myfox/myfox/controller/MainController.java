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
    } else if (Fox.myFoxes.size() == 0 || (name != null && !isFoxOnList(name))) {
      Fox.myFoxes.add(new Fox(name));
      System.out.println("Fox created!");
      Fox.nameOfSelectedFox = name;
      System.out.println(Fox.nameOfSelectedFox);
      Fox.actionsTaken.add(getTimeStamp() + " " + foxSelector(name).getName()
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
    Fox.nameOfSelectedFox = name;
    return "redirect:/?name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String diet(String food, String drink) {
    foxSelector(Fox.nameOfSelectedFox).getDiet()[0] = food;
    foxSelector(Fox.nameOfSelectedFox).getDiet()[1] = drink;
    System.out.println(foxSelector(Fox.nameOfSelectedFox).getDiet()[0]);
    System.out.println(foxSelector(Fox.nameOfSelectedFox).getDiet()[1]);
    Fox.actionsTaken.add(getTimeStamp() + " " + foxSelector(Fox.nameOfSelectedFox).getName()
            + " now eats " + food
            + " and drinks " + drink);
    return "redirect:/?name=" + Fox.myFoxes.get(Fox.myFoxes.size() - 1).getName()
            + "&?food=" + food + "&?drink=" + drink;
  }

  @PostMapping("/trickCenter")
  public String learnTrick(String trick) {
    if (!foxSelector(Fox.nameOfSelectedFox).getTricks().contains(trick)) {
      foxSelector(Fox.nameOfSelectedFox).getTricks().add(trick);
      foxSelector(Fox.nameOfSelectedFox).getAvailableTricks().remove(trick);
      Fox.actionsTaken.add(getTimeStamp() + " " + foxSelector(Fox.nameOfSelectedFox).getName()
              + " learned " + trick);
      updateLatestActionList();
    }
    return "redirect:/?trick=" + trick + "&?food=" + foxSelector(Fox.nameOfSelectedFox).getDiet()[0] + "&?drink="
            + foxSelector(Fox.nameOfSelectedFox).getDiet()[1] + "&?name="
            + foxSelector(Fox.nameOfSelectedFox).getName();
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
      model.addAttribute("name", foxSelector(Fox.nameOfSelectedFox).getName());
      model.addAttribute("nrOfTricks", foxSelector(Fox.nameOfSelectedFox).getTricks().size());
      model.addAttribute("listOfTricks", foxSelector(Fox.nameOfSelectedFox).getTricks());
      model.addAttribute("listOfFoods", foxSelector(Fox.nameOfSelectedFox).getDiet());
      model.addAttribute("food", foxSelector(Fox.nameOfSelectedFox).getDiet()[0]);
      model.addAttribute("drink", foxSelector(Fox.nameOfSelectedFox).getDiet()[1]);
      model.addAttribute("availableTricks", foxSelector(Fox.nameOfSelectedFox).getAvailableTricks());
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

  public Fox foxSelector(String nameOfFox) {
    int k = 0;
    for (int i = 0; i < Fox.myFoxes.size(); i++){
      if (Fox.myFoxes.get(i).getName().equals(nameOfFox)) {
        k = i;
        break;
      }
    }
    return Fox.myFoxes.get(k);
  }

  public boolean isFoxOnList (String nameOfFox) {
    for (int i = 0; i < Fox.myFoxes.size(); i++) {
      if (Fox.myFoxes.get(i).getName().equals(nameOfFox)) {
        return true;
      }
    }
    return false;
  }
}
