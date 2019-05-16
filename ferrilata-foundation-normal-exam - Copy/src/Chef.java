import java.util.HashMap;

public class Chef extends Employee {
  HashMap<String, Integer> meals = new HashMap<>();

  public Chef() {
  }

  public Chef(String name) {
    super(name);
    this.meals = new HashMap<>();
  }

  @Override
  public void work() {
    this.setExperience(this.getExperience() + 1);
  }

  public void cook (String nameOfTheFood) {
    if (this.meals.containsKey(nameOfTheFood)) {
      this.meals.replace(nameOfTheFood, meals.get(nameOfTheFood) + 1);
    } else {
      this.meals.put(nameOfTheFood, 1);
    }
  }
}
