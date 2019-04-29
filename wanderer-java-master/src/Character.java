public abstract class Character {
  private int level;
  private int hp;
  private int dp;
  private int sp;

  public Character() {
  }

  public static int rollDie() {
    return (int) (Math.random() * 6 + 1);
  }

  public void strike () {

  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getDp() {
    return dp;
  }

  public void setDp(int dp) {
    this.dp = dp;
  }

  public int getSp() {
    return sp;
  }

  public void setSp(int sp) {
    this.sp = sp;
  }
}
