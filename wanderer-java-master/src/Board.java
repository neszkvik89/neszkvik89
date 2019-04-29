import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  Hero bigBoy = new Hero();
  int monsterCounter = 0;
  PositionedImage tile = new PositionedImage("img/floor.png", 0, 0);
  PositionedImage wall = new PositionedImage("img/wall.png", 0, 0);
  PositionedImage hero = new PositionedImage("img/hero-down.png", 0, 0);
  PositionedImage heroUp = new PositionedImage("img/hero-up.png", 0, 0);
  PositionedImage heroLeft = new PositionedImage("img/hero-left.png", 0, 0);
  PositionedImage heroRight = new PositionedImage("img/hero-right.png", 0, 0);
  PositionedImage monster = new PositionedImage("img/skeleton.png", 0, 0);

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

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i % 2 != 0 && j % 2 != 0) {
          wall.draw(graphics);
        } else {
          tile.draw(graphics);
          
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
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.hero.getPosY() <= 560 && this.hero.getPosX() % 140 == 0) {
      this.hero.setPosY((this.hero.getPosY() + 70));
      bigBoy.setDirection("down");
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && this.hero.getPosX() > 0 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() - 70);
      bigBoy.setDirection("left");
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.hero.getPosX() <= 560 && this.hero.getPosY() % 140 == 0) {
      this.hero.setPosX(this.hero.getPosX() + 70);
      bigBoy.setDirection("right");
    }
    adjustPositions();
    repaint();
  }
}
