package com.myfox.myfox;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Fox {
  private String name = "";
  private String food = "";
  private String drink = "";
  List<String> availableTricks = new ArrayList<>();
  List<String> tricks = new ArrayList<>();
  String [] diet = new String[2];
  public static List<Fox> myFoxes = new ArrayList<>();
  public static List<String> actionsTaken = new ArrayList<>();
  public static String [] latestActions = new String[5];
  public static String nameOfSelectedFox = "";

  public Fox() {
  }

  public Fox(String name) {
    this.name = name;
    this.availableTricks.add("Eat");
    this.availableTricks.add("Sleep");
    this.availableTricks.add("Play");
    this.availableTricks.add("Catch");
  }

  public Fox(String name, String food, String drink, List<String> tricks) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks = tricks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public List<String> getTricks() {
    return tricks;
  }

  public void setTricks(List<String> tricks) {
    this.tricks = tricks;
  }

  public String[] getDiet() {
    return diet;
  }

  public void setDiet(String[] diet) {
    this.diet = diet;
  }

  public List<String> getAvailableTricks() {
    return availableTricks;
  }

  public void setAvailableTricks(List<String> availableTricks) {
    this.availableTricks = availableTricks;
  }

}




