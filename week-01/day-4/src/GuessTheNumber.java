import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int theNumber = 8;
        int guess = 0;
        boolean won = false;

        while (true) {
            System.out.println("Please type in a number between 1-10");
            guess = myScanner.nextInt();
            if (guess == theNumber) {
                won = true;
                System.out.println("You found the number: " + guess);
                break;
            }
            else if (guess < theNumber) {
                System.out.println("The number is higher");
            }

            else if (guess > theNumber) {
                System.out.println("The number is lower");
            }
        }




        // Write a program that stores a number, and the user has to figure it out.
// The user can input guesses, after each guess the program would tell one
// of the following:
//
// The stored number is higher
// The stried number is lower
// You found the number: 8

    }
}
