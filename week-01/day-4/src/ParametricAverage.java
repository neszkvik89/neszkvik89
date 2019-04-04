import java.util.Scanner;

public class ParametricAverage {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me a number between 1-10");

        int askTimes = myScanner.nextInt();
        int sum = 0;

        for (int i = 0; i < askTimes; i++) {
            System.out.println("Please give me another number");
            int toAdd = myScanner.nextInt();
            sum = sum + toAdd;
        }
        double avg = (double) sum / askTimes;
        System.out.println("Sum: " + sum + ", Average: " + avg);

        // Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4
    }
}
