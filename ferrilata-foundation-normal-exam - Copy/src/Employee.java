public abstract class Employee {
  private String name = "";
  private int experience = 0;

  public abstract void work ();

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }
}
