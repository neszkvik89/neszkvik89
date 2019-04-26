public class Pirate {
  String name = "";
  int gold = 10;
  int hp = 10;
  boolean captain;
  boolean woodenLeg;

  public Pirate(String name, boolean captain, boolean woodenLeg) {
    this.name = name;
    this.captain = captain;
    this.woodenLeg = woodenLeg;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public boolean isCaptain() {
    return captain;
  }

  public void setCaptain(boolean captain) {
    this.captain = captain;
  }

  public boolean isWoodenLeg() {
    return woodenLeg;
  }

  public void setWoodenLeg(boolean woodenLeg) {
    this.woodenLeg = woodenLeg;
  }

  public void work () {
    if (this.isCaptain()) {
      this.setGold(this.getGold() + 10);
      this.setHp(this.getHp() - 5);
    } else {
      this.setGold(this.getGold() + 1);
      this.setHp(this.getHp() -1);
    }
  }

  public void party () {
    if (this.isCaptain()) {
      this.setHp(this.getHp() + 10);
    } else {
      this.setHp(this.getHp() + 1);
    }
  }

  public String toString() {
    if (this.isWoodenLeg()) {
      return "Hello, I'm " + this.getName() + ". I have a wooden leg and " + this.getGold() + " golds.";
    } else {
      return "Hello, I'm " + this.getName() + ". I still have my real legs and " + this.getGold() + " golds.";
    }
  }

}
