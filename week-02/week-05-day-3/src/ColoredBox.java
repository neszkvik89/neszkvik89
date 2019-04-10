import javax.swing.*;
import java.awt.*;

public class ColoredBox {

    public static void mainDraw(Graphics graphics) {

        graphics.setColor(Color.GREEN);
        graphics.drawLine(40, 40, 180, 40);
        graphics.setColor(Color.CYAN);
        graphics.drawLine(40, 180, 180, 180);
        graphics.setColor(Color.MAGENTA);
        graphics.drawLine(180, 40, 180, 180);
        graphics.setColor(Color.ORANGE);
        graphics.drawLine(40, 40, 40,180);



    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
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
