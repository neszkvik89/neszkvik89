import java.util.Scanner;

public class DrawDiamond {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please give me a positive number then press enter!");
            int rows = myScanner.nextInt() / 2 + 1;
            int temp = rows;
            if (rows % 2 == 0) {
                rows--;
            }
            int k = 0;

            for(int i = 1; i <= rows; ++i, k = 0) {
                for(int space = 1; space <= rows - i; ++space) {
                    System.out.print("  ");
                }

                while(k != 2 * i - 1) {
                    System.out.print("* ");
                    ++k;
                }

                System.out.println();
            }

            if (temp % 2 != 0) {rows --;}

        if (temp % 2 == 0) {

            for (int i = rows; i >= 1; --i, k = 0) {
                for (int space = 1; space <= rows - i; ++space) {
                    System.out.print("  ");
                }

                while (k != 2 * i - 1) {
                    System.out.print("* ");
                    ++k;
                }

                System.out.println();
            }
        }

        else {
            for (int i = rows; i >= 1; --i, k = 0) {
            for (int space = 0; space <= rows - i; ++space) {
                System.out.print("  ");
            }

            while (k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }

            System.out.println();
        }

        }
        }
    }

