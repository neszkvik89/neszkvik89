import java.util.Scanner;

public class AverageOfInput {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me an integer then press Enter");
        int firstInt = myScanner.nextInt();
        System.out.println("Please give me a second integer then press Enter");
        int secondInt = myScanner.nextInt();
        System.out.println("Please give me a third integer then press Enter");
        int thirdInt = myScanner.nextInt();
        System.out.println("Please give me a fourth integer then press Enter");
        int fourthInt = myScanner.nextInt();
        System.out.println("Please give me an fifth integer then press Enter");
        int fifthInt = myScanner.nextInt();

        int sum = firstInt + secondInt + thirdInt + fourthInt + fifthInt;
        double avg = (double) sum/5;

        System.out.println("The sum of these integers is " + sum + " and their average is " + avg);
    }
    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4
}
