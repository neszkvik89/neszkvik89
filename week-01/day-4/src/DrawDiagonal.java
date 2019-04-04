import java.util.Scanner;

public class DrawDiagonal {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please give me a number between 3-15");
        int rows = myScanner.nextInt();

        for (int i = 0; i < rows; i++) {
            System.out.print("%");
        }

        System.out.println();
        //System.out.print("%");

        int indent = 0;

        for (int i = 0; i < rows -2 ; i++) {

            System.out.print("%");

            for (int j = 0; j < rows -2; j++) {

                if (indent == j) {
                    System.out.print("%");
                }

                else {
                    System.out.print(" ");
                }

            }
            System.out.print("%");
            System.out.println();
            indent++;
            }

        for (int i = 0; i < rows; i++) {
            System.out.print("%");
        }
        }

        // Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was

    }

