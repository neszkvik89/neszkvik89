import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me a number and press enter!");
        int rows = myScanner.nextInt();

        String triangle = "";

        for (int i = 1; i <= rows; i++) {
            triangle = triangle + "*";
            System.out.println(triangle);
        }

        // Write a program that reads a number from the standard input, then draws a
        // triangle like this:
        //
        // *
        // **
        // ***
        // ****
        //
        // The triangle should have as many lines as the number was

    }
}
