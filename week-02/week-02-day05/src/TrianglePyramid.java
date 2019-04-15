import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TrianglePyramid {

    public static void mainDraw(Graphics graphics, int counter) {
        if (counter < 10) {
            graphics.drawLine(WIDTH - (750 - counter * 50), 750, WIDTH /2 + counter * 25, WIDTH - (750 - counter * 50));
            graphics.drawLine(750 - (counter * 50), 750, WIDTH/2 - counter * 25, WIDTH/4 + counter * 50);
            graphics.drawLine(WIDTH/4 + counter * 25, 750 - counter * 50, 750 - counter * 25, 750 - counter * 50);
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


