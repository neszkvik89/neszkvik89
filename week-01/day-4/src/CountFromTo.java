import java.util.Scanner;

public class CountFromTo {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please give me a number!");
        int firstNum = myScanner.nextInt();

        System.out.println("Please give me another number!");
        int secondNum = myScanner.nextInt();

        if (secondNum <= firstNum) {
            System.out.println("The second number should be bigger");
        }

        else {
            for (int i = firstNum; i < secondNum; i++) {
                System.out.println(i);
            }
        }

        // Create a program that asks for two numbers
// If the second number is not bigger than the first one it should print:
// "The second number should be bigger"
//
// If it is bigger it should count from the first number to the second by one
//
// example:
//
// first number: 3, second number: 6, should print:
//
// 3
// 4
// 5
    }
}
