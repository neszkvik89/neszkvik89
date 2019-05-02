public class Monster extends Character {
  public Monster() {
    this.setLevel(1);
    this.setHp(this.getLevel() * 2 * rollDie());
    this.setCurrentHp(this.getHp());
    this.setDp(this.getLevel() / 2 * rollDie());
    this.setSp(this.getLevel() * rollDie());
    this.setxPos(0);
    this.setyPos(210);
  }
}
