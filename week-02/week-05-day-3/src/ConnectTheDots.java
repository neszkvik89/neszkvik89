import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}

        int [][] array1 = {{10, 10}, {290,  10}, {290, 290}, {10, 290}};
        int [][] array2 = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

        // System.out.println(array2[3][1]); = 90!

        otherDraw(graphics, array1, array2);

    }

    public static void otherDraw (Graphics graphics, int [][] box, int [][] shape) {

        int xpoints[] = {10, 290, 290, 10};
        int ypoints[] = {10, 10, 290, 290};
        int npoints = xpoints.length;

        graphics.drawPolygon(xpoints, ypoints, npoints);

        int x2points[] = {50, 70, 80, 90, 100, 120, 85, 50};
        int y2points[] = {100, 70, 90, 90, 70, 100, 130, 100};
        int n2points = x2points.length;

        graphics.drawPolygon(x2points, y2points, n2points);
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
