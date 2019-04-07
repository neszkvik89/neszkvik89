import java.util.Scanner;

public class ArmstrongNumber {
    /*What is Armstrong number?
    An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits.

            Let's demonstrate this for a 4-digit number: 1634 is a 4-digit number, raise each digit to
            the fourth power, and add: 1^4 + 6^4 + 3^4 + 4^4 = 1634, so it is an Armstrong number.
            For a 3-digit number: 153 is a 3-digit number, raise each digit to the third power,
            and add: 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.
            Exercise
            Write a simple program to check if a given number is an armstrong number. The program should ask for
            a number. E.g. if we type 371, the program should print out: The 371 is an Armstrong number. */

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me a number");

        int number = myScanner.nextInt();
        String digitsString = String.valueOf(number);
        int digits = digitsString.length();
        int sum = 0;
        int [] theDigits = new int[digitsString.length()];

        for (int i = 0; i < digitsString.length(); i++) {
            theDigits[i] = digitsString.charAt(i) - 48;
            sum += Math.pow(theDigits[i], digits);
        }

        boolean isArmstrong = number == sum;

        if (isArmstrong == true) {
            System.out.println(number + " is an Armstrong number!");
        }

        else System.out.println(number + " is NOT an Armstrong number");



    }
}
