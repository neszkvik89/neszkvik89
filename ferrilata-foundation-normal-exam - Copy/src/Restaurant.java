import java.util.ArrayList;
import java.util.List;

public class Restaurant {
  private String name = "";
  private int foundedIn = 0;
  List<Employee> employeeList = new ArrayList<>();

  public Restaurant(String name, int foundedIn) {
    this.name = name;
    this.foundedIn = foundedIn;
    this.employeeList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getFoundedIn() {
    return foundedIn;
  }

  public void setFoundedIn(int foundedIn) {
    this.foundedIn = foundedIn;
  }

  public void hire (Employee toHire) {
    this.employeeList.add(toHire);
  }

  public void guestArrived () {
    for (int i = 0; i < employeeList.size(); i++) {
      employeeList.get(i).work();
    }
  }

  public static void main(String[] args) {
    Restaurant myRestaurant = new Restaurant("Meki", 1994);
    Waiter john = new Waiter();
    Manager bill = new Manager();
    Chef adam = new Chef();
    myRestaurant.hire(john);
    myRestaurant.hire(bill);
    myRestaurant.hire(adam);
    john.work();
    bill.work();
    adam.work();
    adam.cook("Lecsó");
    adam.cook("Vajaskenyér");
    adam.cook("Lecsó");
    for (int i = 0; i < myRestaurant.employeeList.size(); i++) {
      System.out.println(myRestaurant.employeeList.get(i).getExperience());
    }
    System.out.println(john.getTips());
    System.out.println(bill.getMoodLevel());
    System.out.println(adam.meals.entrySet());
  }
}
