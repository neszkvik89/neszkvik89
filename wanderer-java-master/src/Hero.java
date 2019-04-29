public class Hero extends Character {
  String direction = "down";

  public Hero() {
    this.setHp(20 + 3 * rollDie());
    this.setDp(2 * rollDie());
    this.setSp(5 + rollDie());
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public void levelUp () {
    this.setLevel(this.getLevel() + 1);
    this.setHp(this.getHp() + rollDie());
    this.setSp(this.getSp() + rollDie());
    this.setDp(this.getDp() + rollDie());
  }
}
