import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Squares {

    private static final double MAGIC = 1.66;

    public static void mainDraw(Graphics graphics, int ratio, int sizes, int counter){

        if (sizes > 0) {
            int inHeight = (int) (10 * Math.pow((double) ratio, (double) counter));
            graphics.drawRect((int) (WIDTH / 2 - WIDTH / (MAGIC * Math.pow((double) ratio, (double) sizes - 1))), 0, inHeight, inHeight);
            sizes--;
            counter++;
            mainDraw(graphics, ratio, sizes, counter);
        }
    }

    // Don't touch the code below
    static int WIDTH = 540;
    static int HEIGHT = 540;

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
            mainDraw(graphics, 3, 5, 0);
        }
    }
}
