import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  Hero bigBoy = new Hero();
  PositionedImage image = new PositionedImage("img/floor.png", 0, 0);
  PositionedImage wall = new PositionedImage("img/wall.png", 0, 0);
  PositionedImage hero = new PositionedImage("img/hero-down.png", 0, 0);


  //int testBoxX;
  //int testBoxY;

  public Board() {
    //testBoxX = 100;
    //testBoxY = 100; ??? what are these?

    // set the size of your draw board
    setPreferredSize(new Dimension(1000, 1000));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i % 2 != 0 && j % 2 != 0) {
          wall.draw(graphics);
        } else {
          image.draw(graphics);
        }
        image.setPosX(image.getPosX() + 70);
        wall.setPosX(wall.getPosX() + 70);
      }
      image.setPosY(image.getPosY() + 70);
      wall.setPosY(wall.getPosY() + 70);
      image.setPosX(0);
      wall.setPosX(0);
    }
    if (bigBoy.getDirection() == "") {
      hero.draw(graphics);
    } else if (bigBoy.getDirection() == "up") {
    }
    image.setPosX(0);
    image.setPosY(0);
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
    // Here is how you can add a key event listener
    // The board object will be notified when hitting any key
    // with the system calling one of the below 3 methods
    frame.addKeyListener(board);
    // Notice (at the top) that we can only do this
    // because this Board class (the type of the board object) is also a KeyListener
  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box
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
    // and redraw to have a new picture with the new coordinates
    repaint();
  }
}
