import java.util.Scanner;
import java.util.Random;

public class GuessMyNumber {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("On a scale of 1-100 how hard do you want the game to be?");

        int max = myScanner.nextInt();
        System.out.println("I have a number between 1-" +max + " ,lets start the game with 3 lives!");
        int min = 1;
        Random randomNum = new Random();
        int theNumber = min + randomNum.nextInt(max);
        int lives = 3;
        System.out.println("Secret :" + theNumber);


        while (lives > 0) {
            System.out.println("Try to guess the number!");
            int guess = myScanner.nextInt();
            if (guess != theNumber) {
                System.out.println("Wrong answer");
                lives --;
                if (guess < theNumber) {
                    System.out.println("Your number was too low");
                } else {
                    System.out.println("Your number was too high");
                }

                System.out.println("You have " + lives +" lives left.");

            } else {
                System.out.println("Correct, you win the game!");
                break;
            }
        }
        if (lives == 0) {
            System.out.println("No more lives left, game over!");
        }
    }




    /* Exercise
    Write a program where the program chooses a number between 1 and 100. The player is then asked to enter a guess.
    If the player guesses wrong, then the program gives feedback and ask to enter an other guess until the guess
    is correct.
    Make the range customizable (ask for it before starting the guessing).
    You can add lives. (optional)
    Example
    I've the number between 1-100. You have 5 lives.
            20
    Too high. You have 4 lives left.
            10
    Too low. You have 3 lives left.
            15
    Congratulations. You won! */
}
