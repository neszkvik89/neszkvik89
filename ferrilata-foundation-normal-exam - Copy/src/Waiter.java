public class Waiter extends Employee {
  private int tips = 0;

  public Waiter() {
  }

  public Waiter(String name) {
    super(name);
  }

  public int getTips() {
    return tips;
  }

  public void setTips(int tips) {
    this.tips = tips;
  }

  @Override
  public void work() {
    this.setTips(this.getTips() + 1);
    this.setExperience(this.getExperience() + 1);
  }
}
