import java.awt.*;

public abstract class Character {
  private int level;
  private int hp;
  private int currentHp;
  private int dp;
  private int sp;
  private int xPos;
  private int yPos;
  private boolean dead = false;

  public Character() {
  }

  public static int rollDie() {
    return (int) (Math.random() * 6 + 1);
  }

  public void bothStrike (Hero myHero, Monster myMonster, Graphics graphics) {
    int dmgTemp = 0;
    if (myHero.getSp() + 2 * rollDie() > myMonster.getDp()) {
      dmgTemp = (myHero.getSp() + rollDie() * 2 - myMonster.getDp());
      myMonster.setHp(myMonster.getHp() - dmgTemp);
      graphics.drawString("Monster took " + dmgTemp + " damage.", 100, 850);
      if (myMonster.getHp() <= 0) {
        myMonster.setDead(true);
        graphics.drawString("Monster died.", 200, 850);
      }
    } else {
      graphics.drawString("Hero missed with his swing, no damage done.", 100, 850);
    }

    if (myMonster.isDead() != true && myMonster.getSp() + 2 * rollDie() > myHero.getDp()) {
      dmgTemp = (myMonster.getSp() + rollDie() * 2);
      myHero.setHp(myHero.getHp() - dmgTemp);
      graphics.drawString("Hero took " + dmgTemp + " damage.", 100, 900);
      if (myHero.getHp() <= 0) {
        myHero.setDead(true);
        graphics.setColor(Color.RED);
        graphics.drawString("Hero died, GAME OVER!", 300, 300);
        graphics.setColor(Color.BLACK);
      }
    } else {
      graphics.drawString("Monster missed with his swing, no damage done.", 100, 900);
    }



  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getCurrentHp() {
    return currentHp;
  }

  public void setCurrentHp(int currentHp) {
    this.currentHp = currentHp;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getxPos() {
    return xPos;
  }

  public void setxPos(int xPos) {
    this.xPos = xPos;
  }

  public int getyPos() {
    return yPos;
  }

  public void setyPos(int yPos) {
    this.yPos = yPos;
  }

  public boolean isDead() {
    return dead;
  }

  public void setDead(boolean dead) {
    this.dead = dead;
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
