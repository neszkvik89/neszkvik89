

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SuperHexagon extends JFrame {

    public static void mainDraw(Graphics graphics, int counter) {
        if (counter < 7) {
            graphics.drawLine(25 + counter * 75, 120 + counter * 40, 25 + 50 + counter * 75, 120 + counter * 40);
            graphics.drawLine(75 + counter * 75, 120 + counter * 40, 2 * 25 + 50 + counter * 75, 160 + counter * 40);
            graphics.drawLine(100 + counter * 75, 160 + counter * 40, 25 + 50 + counter * 75, 200 + counter * 40);
            graphics.drawLine(75 + counter * 75, 200 + counter * 40, 25 + counter * 75, 200 + counter * 40);
            graphics.drawLine(25 + counter * 75, 200 + counter * 40, 0 + counter * 75, 160 + counter * 40);
            graphics.drawLine(0 + counter * 75, 160 + counter * 40, 25 + counter * 75, 120 + counter * 40);
            counter++;
            mainDraw(graphics, counter);
        }
        secondDraw(graphics, counter);
        thirdDraw(graphics, counter);
        fourthDraw(graphics, counter);
    }

    public static void secondDraw(Graphics graphics, int counter) { //mid+1
        if (counter == 7) {counter = 0;}
        if (counter < 6) {
            graphics.drawLine(100 + counter * 75, 80 + counter * 40, 150 + counter * 75, 80 + counter * 40);
            graphics.drawLine(150 + counter * 75, 80 + counter * 40, 175 + counter * 75, 120 + counter * 40);
            graphics.drawLine(175 + counter * 75, 120 + counter * 40, 150 + counter * 75, 160 + counter * 40);
            graphics.drawLine(150 + counter * 75, 160 + counter * 40, 100 + counter * 75, 160 + counter * 40);
            graphics.drawLine(100 + counter * 75, 160 + counter * 40, 75 + counter * 75, 120 + counter * 40);
            graphics.drawLine(75 + counter * 75, 120 + counter * 40, 100 + counter * 75, 80 + counter * 40);
            counter++;
            secondDraw(graphics, counter);
        }
    }

    public static void thirdDraw(Graphics graphics, int counter) { //mid+2
        if (counter == 6) {counter = 0;}
        if (counter < 5) {
            graphics.drawLine(175 + counter * 75, 40 + counter * 40, 225 + counter * 75, 40 + counter * 40);
            graphics.drawLine(225 + counter * 75, 40 + counter * 40, 250 + counter * 75, 80 + counter * 40);
            graphics.drawLine(250 + counter * 75, 80 + counter * 40, 225 + counter * 75, 120 + counter * 40);
            graphics.drawLine(225 + counter * 75, 120 + counter * 40, 175 + counter * 75, 120 + counter * 40);
            graphics.drawLine(175 + counter * 75, 120 + counter * 40, 150 + counter * 75, 80 + counter * 40);
            graphics.drawLine(150 + counter * 75, 80 + counter * 40, 175 + counter * 75, 40 + counter * 40);
            counter++;
            thirdDraw(graphics, counter);
        }
    }

    public static void fourthDraw(Graphics graphics, int counter) {
        if (counter == 5) {counter = 0;}
        if (counter < 4) {
            graphics.drawLine(250 + counter * 75, 0 + counter * 40, 300 + counter * 75, 0 + counter * 40);
            graphics.drawLine(300 + counter * 75, 0 + counter * 40, 325 + counter * 75, 40 + counter * 40);
            graphics.drawLine(325 + counter * 75, 40 + counter * 40, 300 + counter * 75, 80 + counter * 40);
            graphics.drawLine(300 + counter * 75, 80 + counter * 40, 250 + counter * 75, 80 + counter * 40);
            graphics.drawLine(250 + counter * 75, 80 + counter * 40, 225 + counter * 75, 40 + counter * 40);
            graphics.drawLine(225 + counter * 75, 40 + counter * 40, 250 + counter * 75, 0 + counter * 40);
            counter++;
            fourthDraw(graphics, counter);
        }

    }

    public static void secondMirrorDraw(Graphics graphics, int counter) { //mid+1
        if (counter == 7) {
            counter = 0;
        }
        if (counter < 6) {
            graphics.drawLine(100 + counter * 75, 80 + counter * 40, 150 + counter * 75, 80 + counter * 40);
            graphics.drawLine(150 + counter * 75, 80 + counter * 40, 175 + counter * 75, 120 + counter * 40);
            graphics.drawLine(175 + counter * 75, 120 + counter * 40, 150 + counter * 75, 160 + counter * 40);
            graphics.drawLine(150 + counter * 75, 160 + counter * 40, 100 + counter * 75, 160 + counter * 40);
            graphics.drawLine(100 + counter * 75, 160 + counter * 40, 75 + counter * 75, 120 + counter * 40);
            graphics.drawLine(75 + counter * 75, 120 + counter * 40, 100 + counter * 75, 80 + counter * 40);
            counter++;
            secondDraw(graphics, counter);
        }
    }

    // Don't touch the code below
    static int WIDTH = 1000;
    static int HEIGHT = 800;

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
    }}