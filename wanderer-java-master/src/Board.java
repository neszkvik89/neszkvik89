import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  public static int turnCounter = 0;
  Hero bigBoy = new Hero();
  int monsterCounter = 0;
  PositionedImage tile = new PositionedImage("img/floor.png", 0, 0);
  PositionedImage wall = new PositionedImage("img/wall.png", 0, 0);
  PositionedImage hero = new PositionedImage("img/hero-down.png", 0, 0);
  PositionedImage heroUp = new PositionedImage("img/hero-up.png", 0, 0);
  PositionedImage heroLeft = new PositionedImage("img/hero-left.png", 0, 0);
  PositionedImage heroRight = new PositionedImage("img/hero-right.png", 0, 0);
  PositionedImage monster = new PositionedImage("img/skeleton.png", 280, 420);
  PositionedImage monster2 = new PositionedImage("img/skeleton.png", 420, 560);
  PositionedImage monster3 = new PositionedImage("img/skeleton.png", 560, 140);
  PositionedImage boss = new PositionedImage("img/boss.png", 0, 0);

  public void moveMonster(PositionedImage aMonster) {
    int dirDecider = (int) (Math.random() * 4) + 1;
    if (dirDecider == 1 && aMonster.getPosY() != 630 && aMonster.getPosX() % 140 == 0) {
      aMonster.setPosY(aMonster.getPosY() + 70);
    } else if (dirDecider == 2 && aMonster.getPosY() != 0 && aMonster.getPosX() % 140 == 0) {
      aMonster.setPosY(aMonster.getPosY() - 70);
    } else if (dirDecider == 3 && aMonster.getPosX() != 630 && aMonster.getPosY() % 140 == 0) {
      aMonster.setPosX(aMonster.getPosX() + 70);
    } else if (dirDecider == 4 && aMonster.getPosX() != 0 && aMonster.getPosY() % 140 == 0) {
      aMonster.setPosX(aMonster.getPosX() - 70);
    }
  }

    /* over-complicated way to pseudo-randomly move them, ditched it
    boolean canMoveUp = aMonster.getPosY() != 0 && aMonster.getPosX() % 140 == 0;
    boolean canMoveDown = aMonster.getPosY() != 630 && aMonster.getPosX() % 140 == 0;
    boolean canMoveRight = aMonster.getPosX() != 630 && aMonster.getPosY() % 140 == 0;
    boolean canMoveLeft = aMonster.getPosX() != 0 && aMonster.getPosY() % 140 == 0;

    if (canMoveDown) {
      aMonster.setPosY(aMonster.getPosY() + 70);
    } else if (canMoveRight) {
      aMonster.setPosX(aMonster.getPosX() + 70);
    } else if (canMoveLeft) {
      aMonster.setPosY(aMonster.getPosX() - 70);
    } else if (canMoveUp){
      aMonster.setPosX(aMonster.getPosY() - 70);
    } */


  public Board() {
    setPreferredSize(new Dimension(1000, 1000));
    setVisible(true);
  }

  public void adjustPositions () {
    heroUp.setPosX(hero.getPosX());
    heroLeft.setPosX(hero.getPosX());
    heroRight.setPosX(hero.getPosX());
    heroUp.setPosY(hero.getPosY());
    heroLeft.setPosY(hero.getPosY());
    heroRight.setPosY(hero.getPosY());
  }

  public void paintMonster(Graphics graphics) {

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
          if (i + j!= 0 && Math.random() * 100  + i> 95 && monsterCounter == 0) {
            monster.setPosY(i * 70);
            monster.setPosX(j * 70);
            monsterCounter++;
          } else if (Math.random() * 100 + i> 95 && monsterCounter == 1) {
            monster2.setPosY(i * 70);
            monster2.setPosX(j * 70);
            monsterCounter++;
          } else if (Math.random() * 100 + j + i> 95 && monsterCounter == 2) {
            monster2.setPosY(i * 70);
            monster2.setPosX(j * 70);
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

    if (bigBoy.getDirection() == "down") {
      hero.draw(graphics);
    } else if (bigBoy.getDirection() == "up") {
      heroUp.draw(graphics);
    } else if (bigBoy.getDirection() == "left") {
      heroLeft.draw(graphics);
    } else {
      heroRight.draw(graphics);
    }

    if (turnCounter % 2 == 0) {
      moveMonster(monster);
      moveMonster(monster2);
      moveMonster(monster3);
    }

    monster.draw(graphics);
    monster2.draw(graphics);
    monster3.draw(graphics);
    tile.setPosX(0);
    tile.setPosY(0);
    wall.setPosY(0);
    wall.setPosX(0);
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
       bigBoy.setDirection("up");
       turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.hero.getPosY() <= 560 && this.hero.getPosX() % 140 == 0) {
      this.hero.setPosY((this.hero.getPosY() + 70));
      bigBoy.setDirection("down");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && this.hero.getPosX() > 0 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() - 70);
      bigBoy.setDirection("left");
      turnCounter++;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.hero.getPosX() <= 560 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() + 70);
      bigBoy.setDirection("right");
      turnCounter++;
    }
    adjustPositions();
    repaint();
  }
}
