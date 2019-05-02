import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Board extends JComponent implements KeyListener {
  public static ArrayList<Monster> myMonsters = new ArrayList<>();

  public static ArrayList<PositionedImage> myMonsterImages = new ArrayList<>();
  public static int turnCounter = 0;
  Hero theHero = new Hero();
  Boss theBoss = new Boss();
  int monsterCounter = 0;
  PositionedImage tile = new PositionedImage("img/floor.png", 0, 0);
  PositionedImage wall = new PositionedImage("img/wall.png", 0, 0);
  PositionedImage heroDown = new PositionedImage("img/hero-down.png", theHero.getxPos(), theHero.getyPos());
  PositionedImage heroUp = new PositionedImage("img/hero-up.png", theHero.getxPos(), theHero.getyPos());
  PositionedImage heroLeft = new PositionedImage("img/hero-left.png", theHero.getxPos(), theHero.getyPos());
  PositionedImage heroRight = new PositionedImage("img/hero-right.png", theHero.getxPos(), theHero.getyPos());
  PositionedImage boss = new PositionedImage("img/boss.png", theBoss.getxPos(), theBoss.getyPos());
  public Board() {
    setPreferredSize(new Dimension(1000, 1000));
    setVisible(true);
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

  public void fillMonsterList () {
    for (int i = 0; i < (int) Math.random() * 6 + 1; i++) {
      myMonsters.add(new Monster());
    }
    myMonsters.add(new Boss());
  }

  public void fillMonsterImagesList () {
    for (int i = 0; i < myMonsters.size(); i++) {
      myMonsterImages.add(i, new PositionedImage("img/skeleton.png", myMonsters.get(i).getxPos(), myMonsters.get(i).getyPos()));
    }
    myMonsterImages.add(myMonsterImages.size() - 1, new PositionedImage("img/boss.png", 0, 0);
  }

  public void combat (Monster myMonster) {
    while (!theHero.isDead() && !myMonster.isDead()) {
      theHero.bothStrike(theHero, myMonster);
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

  public void adjustPositions () {
    heroUp.setPosX(heroDown.getPosX());
    heroLeft.setPosX(heroDown.getPosX());
    heroRight.setPosX(heroDown.getPosX());
    heroUp.setPosY(heroDown.getPosY());
    heroLeft.setPosY(heroDown.getPosY());
    heroRight.setPosY(heroDown.getPosY());
  }

  public void reset () {
    theHero.levelUp();
    theHero.setyPos(0);
    theHero.setxPos(0);
    theHero.setHasKey(false);
    heroDown.setPosX(theHero.getxPos());
    heroUp.setPosX(theHero.getxPos());
    heroRight.setPosX(theHero.getxPos());
    heroLeft.setPosX(theHero.getxPos());
    heroDown.setPosY(theHero.getyPos());
    heroUp.setPosY(theHero.getyPos());
    heroRight.setPosY(theHero.getyPos());
    heroLeft.setPosY(theHero.getyPos());
    int heroEffectDecider = (int) (Math.random() * 100 + 1);
    if (heroEffectDecider > 90) {
      theHero.setCurrentHp(theHero.getHp());
    } else if (heroEffectDecider > 50) {
      theHero.setCurrentHp(Math.min(theHero.getCurrentHp() + theHero.getHp() / 3, theHero.getHp()));
    } else {
      theHero.setCurrentHp((int) (Math.min(theHero.getCurrentHp() + theHero.getHp() * 0.1, theHero.getHp())));
    }
    monsterCounter = 0;
    levelUpCharacters(myMonsters);

  }

  public void levelUpCharacters(ArrayList<Monster> characterList) {
    for (int i = 0; i < characterList.size(); i++) {
      characterList.get(i).setDead(false);
      characterList.get(i).setLevel(characterList.get(i).getLevel());
      characterList.get(i).setHp(characterList.get(i).getLevel() * 2 * Character.rollDie());
      characterList.get(i).setCurrentHp(characterList.get(i).getHp());
      characterList.get(i).setDp(characterList.get(i).getLevel() / 2 * Character.rollDie());
      characterList.get(i).setSp(characterList.get(i).getLevel() * Character.rollDie());
    }
  }

  @Override
  public void paint(Graphics graphics) {

    super.paint(graphics);
    fillMonsterList();
    fillMonsterImagesList();
    skeleton3.setHasKey(true);
    if (theHero.isHasKey() && theBoss.isDead()) {
      reset();
    }

    if (theHero.getCurrentHp() <= 0) {
      graphics.setColor(Color.RED);
      graphics.drawString("GAME OVER", 300, 300);
    }

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
          } else if (i + j!= 0 && Math.random() * 100 + i> 95 && monsterCounter == 1 && !skeleton2.isDead()) {
            monster2.setPosY(i * 70);
            monster2.setPosX(j * 70);
            skeleton2.setyPos(i * 70);
            skeleton2.setxPos(j * 70);
            monsterCounter++;
          } else if (i + j!= 0 && Math.random() * 100 + j + i> 95 && monsterCounter == 2 && !skeleton3.isDead()) {
            monster3.setPosY(i * 70);
            monster3.setPosX(j * 70);
            skeleton3.setyPos(i * 70);
            skeleton3.setxPos(j * 70);
            monsterCounter++;
          } else if (i + j!= 0 && Math.random() * 100 + i + j > 95 && monsterCounter == 3 && !theBoss.isDead()) {
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
      heroDown.draw(graphics);
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

    tile.setPosX(0);
    tile.setPosY(0);
    wall.setPosY(0);
    wall.setPosX(0);
    graphics.drawString("Hero (Level " + theHero.getLevel() + " ) HP: " + theHero.getCurrentHp() + "/" + theHero.getHp() + " x: " + theHero.getxPos() + " y: " + theHero.getyPos() + " "
         + " ł DP: " + theHero.getDp() + " ł SP: " + theHero.getSp() + " " + " isdead? " + theHero.isDead(), 100, 765);
    graphics.drawString("nr1: " + skeleton1.getCurrentHp() + " " + skeleton1.getDp() + " " + skeleton1.getSp() + " " + skeleton1.isDead() + skeleton1.getLevel(), 100, 780);
    graphics.drawString("nr2: " + skeleton2.getCurrentHp() + " " + skeleton2.getDp() + " " + skeleton2.getSp() + " " + skeleton2.isDead() + skeleton2.getLevel(), 100, 795);
    graphics.drawString("nr3: " + skeleton3.getCurrentHp() + " " + skeleton3.getDp() + " " + skeleton3.getSp() + " " + skeleton3.isDead() + skeleton3.getLevel(), 100, 810);
    graphics.drawString("Boss: " + theBoss.getCurrentHp() + " " + theBoss.getDp() + " " + theBoss.getSp() + " " + theBoss.isDead() + theBoss.getLevel(), 100, 825);
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

    if (e.getKeyCode() == KeyEvent.VK_UP && this.heroDown.getPosY() > 0 && this.heroDown.getPosX() % 140 == 0) {
       this.heroDown.setPosY(this.heroDown.getPosY() - 70);
       theHero.setyPos(theHero.getyPos() - 70);
       theHero.setDirection("up");
       turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.heroDown.getPosY() <= 560 && this.heroDown.getPosX() % 140 == 0) {
      this.heroDown.setPosY((this.heroDown.getPosY() + 70));
      theHero.setyPos(theHero.getyPos() + 70);
      theHero.setDirection("down");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && this.heroDown.getPosX() > 0 && this.heroDown.getPosY() % 140 == 0) {
      this.heroDown.setPosX(this.heroDown.getPosX() - 70);
      theHero.setxPos(theHero.getxPos() - 70);
      theHero.setDirection("left");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.heroDown.getPosX() <= 560 && this.heroDown.getPosY() % 140 == 0) {
      this.heroDown.setPosX(this.heroDown.getPosX() + 70);
      theHero.setxPos(theHero.getxPos() + 70);
      theHero.setDirection("right");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      if (theHero.getyPos() == skeleton1.getyPos() && theHero.getxPos() == skeleton1.getxPos()) {
        combat(skeleton1);
      } else if (theHero.getyPos() == skeleton2.getyPos() && theHero.getxPos() == skeleton2.getxPos()) {
        combat(skeleton2);
      } else if (theHero.getyPos() == skeleton3.getyPos() && theHero.getxPos() == skeleton3.getxPos()) {
        combat(skeleton3);
      } else if (theHero.getyPos() == theBoss.getyPos() && theHero.getxPos() == theBoss.getxPos()) {
        combat(theBoss);
      }
    }
    adjustPositions();
    repaint();
  }
}
