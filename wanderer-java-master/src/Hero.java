public class Hero extends Character {
  String direction = "down";

  public Hero() {
    this.setLevel(1);
    this.setHp(30 + 3 * rollDie());
    this.setCurrentHp(this.getHp());
    this.setDp(2 * rollDie() + 4);
    this.setSp(5 + rollDie());
    this.setxPos(0);
    this.setyPos(0);
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
