import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  public static int turnCounter = 0;
  Hero theHero = new Hero();
  Boss theBoss = new Boss();
  Monster skeleton1 = new Monster();
  Monster skeleton2 = new Monster();
  Monster skeleton3 = new Monster();
  int monsterCounter = 0;
  PositionedImage tile = new PositionedImage("img/floor.png", 0, 0);
  PositionedImage wall = new PositionedImage("img/wall.png", 0, 0);
  PositionedImage hero = new PositionedImage("img/hero-down.png", 0, 0);
  PositionedImage heroUp = new PositionedImage("img/hero-up.png", 0, 0);
  PositionedImage heroLeft = new PositionedImage("img/hero-left.png", 0, 0);
  PositionedImage heroRight = new PositionedImage("img/hero-right.png", 0, 0);
  PositionedImage monster1 = new PositionedImage("img/skeleton.png", 0, 0);
  PositionedImage monster2 = new PositionedImage("img/skeleton.png", 0, 0);
  PositionedImage monster3 = new PositionedImage("img/skeleton.png", 0, 0);
  PositionedImage boss = new PositionedImage("img/boss.png", 0, 0);

  public void combatPartner (Graphics graphics) {
    if (theHero.getyPos() == skeleton1.getyPos() && theHero.getxPos() == skeleton1.getxPos()) {
      combat(skeleton1, graphics);
    } else if (theHero.getyPos() == skeleton2.getyPos() && theHero.getxPos() == skeleton2.getxPos()) {
      combat(skeleton2, graphics);
    } else if (theHero.getyPos() == skeleton3.getyPos() && theHero.getxPos() == skeleton3.getxPos()) {
      combat(skeleton3, graphics);
    } else if (theHero.getyPos() == theBoss.getyPos() && theHero.getxPos() == theBoss.getxPos()) {
      combat(theBoss, graphics);
    }
  }

  public void combat (Monster myMonster, Graphics graphics) {
    while (!theHero.isDead() && !myMonster.isDead()) {
      theHero.bothStrike(theHero, myMonster, graphics);
    }
  }

  public void moveMonster(PositionedImage aMonster, Monster aSkeleton) {
    int dirDecider = (int) (Math.random() * 4) + 1;
    if (!aSkeleton.isDead() && dirDecider == 1 && aMonster.getPosY() != 630 && aMonster.getPosX() % 140 == 0) {
      aMonster.setPosY(aMonster.getPosY() + 70);
      aSkeleton.setyPos(aSkeleton.getyPos() + 70);
    } else if (!aSkeleton.isDead() && dirDecider == 2 && aMonster.getPosY() != 0 && aMonster.getPosX() % 140 == 0) {
      aMonster.setPosY(aMonster.getPosY() - 70);
      aSkeleton.setyPos(aSkeleton.getyPos() - 70);
    } else if (!aSkeleton.isDead() && dirDecider == 3 && aMonster.getPosX() != 630 && aMonster.getPosY() % 140 == 0) {
      aMonster.setPosX(aMonster.getPosX() + 70);
      aSkeleton.setxPos(aSkeleton.getxPos() + 70);
    } else if (!aSkeleton.isDead() && dirDecider == 4 && aMonster.getPosX() != 0 && aMonster.getPosY() % 140 == 0) {
      aMonster.setPosX(aMonster.getPosX() - 70);
      aSkeleton.setxPos(aSkeleton.getxPos() - 70);
    }
  }

  public Board() {
    setPreferredSize(new Dimension(1000, 1000));
    setVisible(true);
  }

  public void combat (Hero myHero, Monster myMonster, Graphics graphics) {
    graphics.setColor(Color.red);
    graphics.drawRect(300, 300, 300, 300);
  }

  public void adjustPositions () {
    heroUp.setPosX(hero.getPosX());
    heroLeft.setPosX(hero.getPosX());
    heroRight.setPosX(hero.getPosX());
    heroUp.setPosY(hero.getPosY());
    heroLeft.setPosY(hero.getPosY());
    heroRight.setPosY(hero.getPosY());
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i % 2 != 0 && j % 2 != 0) {
          wall.draw(graphics);
        } else {
          tile.draw(graphics);
          if (i + j!= 0 && Math.random() * 100  + i> 95 && monsterCounter == 0 && !skeleton1.isDead()) {
            monster1.setPosY(i * 70);
            monster1.setPosX(j * 70);
            skeleton1.setyPos(i * 70);
            skeleton1.setxPos(j * 70);
            monsterCounter++;
          } else if (Math.random() * 100 + i> 95 && monsterCounter == 1 && !skeleton2.isDead()) {
            monster2.setPosY(i * 70);
            monster2.setPosX(j * 70);
            skeleton2.setyPos(i * 70);
            skeleton2.setxPos(j * 70);
            monsterCounter++;
          } else if (Math.random() * 100 + j + i> 95 && monsterCounter == 2 && !skeleton3.isDead()) {
            monster2.setPosY(i * 70);
            monster2.setPosX(j * 70);
            skeleton3.setyPos(i * 70);
            skeleton3.setxPos(j * 70);
            monsterCounter++;
          } else if (Math.random() * 100 + i + j > 95 && monsterCounter == 3 && !theBoss.isDead()) {
            boss.setPosX(j * 70);
            boss.setPosY(i * 70);
            theBoss.setxPos(j * 70);
            theBoss.setyPos(i * 70);
            monsterCounter++;
          }
        }
        tile.setPosX(tile.getPosX() + 70);
        wall.setPosX(wall.getPosX() + 70);
      }
      tile.setPosY(tile.getPosY() + 70);
      wall.setPosY(wall.getPosY() + 70);
      tile.setPosX(0);
      wall.setPosX(0);
    }

    if (theHero.getDirection().equals("down")) {
      hero.draw(graphics);
    } else if (theHero.getDirection().equals("up")) {
      heroUp.draw(graphics);
    } else if (theHero.getDirection().equals("left")) {
      heroLeft.draw(graphics);
    } else {
      heroRight.draw(graphics);
    }

    if (turnCounter % 2 == 0) {
      moveMonster(monster1, skeleton1);
      moveMonster(monster2, skeleton2);
      moveMonster(monster3, skeleton3);
    }

    if (!skeleton1.isDead()) {
      monster1.draw(graphics);
    }
    if (!skeleton2.isDead()) {
      monster2.draw(graphics);
    }
    if (!skeleton3.isDead()){
      monster3.draw(graphics);
    }
    if (!theBoss.isDead()) {
      boss.draw(graphics);
    }

    if (theHero.getxPos() == skeleton1.getxPos() && theHero.getyPos() == skeleton1.getyPos()) {
      combat(theHero, skeleton1, graphics);
    } else if (theHero.getxPos() == skeleton2.getxPos() && theHero.getyPos() == skeleton2.getyPos()) {
      combat(theHero, skeleton2, graphics);
    } else if (theHero.getxPos() == skeleton3.getxPos() && theHero.getyPos() == skeleton3.getyPos()) {
      combat(theHero, skeleton3, graphics);
    } else if (theHero.getxPos() == theBoss.getxPos() && theHero.getyPos() == theBoss.getyPos()) {
      combat(theHero, theBoss, graphics);
    }
    tile.setPosX(0);
    tile.setPosY(0);
    wall.setPosY(0);
    wall.setPosX(0);
    graphics.drawString("Hero (Level " + theHero.getLevel() + " ) HP: " + theHero.getCurrentHp() + "/" + theHero.getHp()
        + " ł DP: " + theHero.getDp() + " ł SP: " + theHero.getSp() + "    " + skeleton1.getxPos() + " "
        + skeleton1.getyPos() + "HP: " + skeleton1.getCurrentHp(), 100, 750);
    combatPartner(graphics);
  }

  public static void main(String[] args) {
    // Here is how you set up a new window and adding our board to it
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();

    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(board);
  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }


  @Override
  public void keyReleased(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_UP && this.hero.getPosY() > 0 && this.hero.getPosX() % 140 == 0) {
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
      turnCounter++;
    }
    adjustPositions();
    repaint();
  }
}
