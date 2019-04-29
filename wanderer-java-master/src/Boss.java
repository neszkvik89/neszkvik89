public class Boss extends Monster {
  public Boss() {
    this.setHp(this.getLevel() * 2 * rollDie() + rollDie());
    this.setDp(this.getLevel() / 2 * rollDie() + rollDie() / 2);
    this.setSp(this.getLevel() * rollDie() + this.getLevel());
  }
}
