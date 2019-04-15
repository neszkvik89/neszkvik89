import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics, int counter) {
        if (counter < 16) {
            graphics.setColor(Color.magenta);
            graphics.drawLine(200 + 50 * counter, 0, 1000, 50 * counter);
            graphics.setColor(Color.GREEN);
            graphics.drawLine(0, 200 + counter * 50, counter * 50, 1000);
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
            mainDraw(graphics, 0);
        }
    }
}
