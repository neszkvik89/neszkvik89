import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {
  private int age = 0;
  private String color = "";
  private String name = "";

  public Fox(int age, String color, String name) {
    this.age = age;
    this.color = color;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {

    ArrayList<Fox> myFoxes = new ArrayList<>();
    myFoxes.add(new Fox(3, "blue", "jack"));
    myFoxes.add(new Fox(8, "red", "joe"));
    myFoxes.add(new Fox(2, "blue", "bill"));
    myFoxes.add(new Fox(0, "green", "jeremiah"));
    myFoxes.add(new Fox(12, "green", "homer"));

    List<Fox> greenFoxes = myFoxes.stream()
        .filter(n -> n.getColor().equals("green"))
        .collect(Collectors.toList());

    List<Fox> greenBelow5Foxes = myFoxes.stream()
        .filter(n -> n.getColor().equals("green"))
        .filter(n -> n.getAge() < 5)
        .collect(Collectors.toList());

    System.out.println(foxColorFreq(myFoxes).entrySet());
  }
  //do not see how to refactor into a simpler version with streams
  public static HashMap<String, Integer> foxColorFreq (ArrayList<Fox> myFoxes) {
    HashMap<String, Integer> foxesWithSpecificColors = new HashMap<>();
    for (int i = 0; i < myFoxes.size(); i++) {
      if (foxesWithSpecificColors.containsKey(myFoxes.get(i).getColor())) {
        foxesWithSpecificColors.replace(myFoxes.get(i).getColor(), foxesWithSpecificColors.get(myFoxes.get(i).getColor()) + 1);
      } else {
        foxesWithSpecificColors.put(myFoxes.get(i).getColor(), 1);
      }
    }
    return foxesWithSpecificColors;
  }
}
