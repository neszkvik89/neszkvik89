import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics, int counter) {
        if (counter < 11) {
            //not really sure why the drawing is not precise...
            graphics.setColor(Color.GREEN);
            graphics.drawLine(WIDTH/2 - counter * 12, WIDTH - counter * 37, WIDTH/2 - counter * 50, WIDTH/2);
            graphics.drawLine(WIDTH/2 + counter * 12, WIDTH - counter * 37, WIDTH/2 + counter * 50, WIDTH/2);
            graphics.drawLine(WIDTH/2 + counter * 12, 0 + counter * 37, WIDTH/2 + counter * 50, WIDTH/2);
            graphics.drawLine(WIDTH/2 - counter * 12, 0 + counter * 37, WIDTH/2 - counter * 50, WIDTH/2);
            graphics.drawLine(0 + counter * 37, WIDTH/2 + counter * 12, WIDTH/2,  WIDTH/2 + counter * 50);
            graphics.drawLine(0 + counter * 37, WIDTH/2 - counter * 12,  WIDTH/2, WIDTH/2 - counter * 50);
            graphics.drawLine(WIDTH - counter * 37, WIDTH/2 - counter * 12,  WIDTH/2, WIDTH/2 - counter * 50);
            graphics.drawLine(WIDTH - counter * 37, WIDTH/2 + counter * 12, WIDTH/2,  WIDTH/2 + counter * 50);
            counter++;
            mainDraw(graphics, counter);
        }
    }

    // Don't touch the code below
    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics, 1);
        }
    }
}
