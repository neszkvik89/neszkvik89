import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Character implements KeyListener {
  private int level;
  private int hp;
  private int currentHp;
  private int dp;
  private int sp;
  private int xPos;
  private int yPos;
  private boolean dead = false;
  private boolean hasKey = false;

  public Character() {
  }

  public static int rollDie() {
    return (int) (Math.random() * 6 + 1);
  }

  public void bothStrike(Hero myHero, Monster myMonster) {
    int dmgTemp;

    if (myHero.getSp() + 2 * rollDie() > myMonster.getDp()) {
      dmgTemp = (myHero.getSp() + rollDie() * 2 - myMonster.getDp());
      myMonster.setCurrentHp(myMonster.getCurrentHp() - dmgTemp);
      if (myMonster.getCurrentHp() <= 0) {
        myMonster.setDead(true);
        myMonster.setxPos(Integer.MAX_VALUE);
        myMonster.setyPos(Integer.MAX_VALUE);
        if (myMonster.isHasKey()) {
          myHero.setHasKey(true);
          myMonster.setHasKey(false);
        }
      }
    }

    if (myMonster.getSp() + 2 * rollDie() > myHero.getDp()) {
      dmgTemp = (myMonster.getSp() + rollDie() * 2);
      myHero.setCurrentHp(myHero.getCurrentHp() - dmgTemp);

      if (myHero.getCurrentHp() <= 0) {
        myHero.setDead(true);
        myHero.setxPos(Integer.MAX_VALUE);
        myHero.setyPos(Integer.MAX_VALUE);
      }
    }
  }

  public boolean isHasKey() {
    return hasKey;
  }

  public void setHasKey(boolean hasKey) {
    this.hasKey = hasKey;
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

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }


  @Override
  public void keyReleased(KeyEvent e) {

    /* if (e.getKeyCode() == KeyEvent.VK_SPACE && this.hero.getPosY() > 0 && this.hero.getPosX() % 140 == 0) {
      this.hero.setPosY(this.hero.getPosY() - 70);
      theHero.setyPos(theHero.getyPos() - 70);
      theHero.setDirection("up");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.hero.getPosY() <= 560 && this.hero.getPosX() % 140 == 0) {
      this.hero.setPosY((this.hero.getPosY() + 70));
      theHero.setyPos(theHero.getyPos() + 70);
      theHero.setDirection("down");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && this.hero.getPosX() > 0 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() - 70);
      theHero.setxPos(theHero.getxPos() - 70);
      theHero.setDirection("left");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.hero.getPosX() <= 560 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() + 70);
      theHero.setxPos(theHero.getxPos() + 70);
      theHero.setDirection("right");
      turnCounter++; */
  }
}
