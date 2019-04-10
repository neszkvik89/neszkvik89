import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a line drawing function that takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        otherDraw(graphics, 0, 0);
    }

    public static void otherDraw(Graphics graphics, int x, int y) {
        int size = 20;


        // i also functions as a counter
        for (int i = 0; i < 17; i++) {

            graphics.drawLine(i * size, 0, WIDTH/2, HEIGHT/2);
            graphics.drawLine(i * size, HEIGHT, WIDTH/2, HEIGHT/2);
            graphics.drawLine(0,  i * size, WIDTH/2, HEIGHT/2);
            graphics.drawLine(WIDTH,  i * size, WIDTH/2, HEIGHT/2);



        }

    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

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
            mainDraw(graphics);
        }
    }
}
