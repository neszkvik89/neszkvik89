import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please type in a number and press enter!");
        int base = myScanner.nextInt();

        for (int i = 1; i < 11; i++) {
            System.out.println(base+ " x " + i + " = " + base * i);
        }

    }
}
