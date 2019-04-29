public class Monster extends Character {
  public Monster() {
    this.setHp(this.getLevel() * 2 * rollDie());
    this.setDp(this.getLevel() / 2 * rollDie());
    this.setSp(this.getLevel() * rollDie());
  }
}
