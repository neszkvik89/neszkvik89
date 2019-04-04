import java.util.Scanner;
public class PrintBigger {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me an integer");
        int firstInt = myScanner.nextInt();
        System.out.println("Please give me another integer");
        int secondInt = myScanner.nextInt();

        if (firstInt > secondInt) {
            System.out.println(firstInt);
        } else {
            System.out.println(secondInt);
        }



        // Write a program that asks for two numbers and prints the bigger one

    }
}
