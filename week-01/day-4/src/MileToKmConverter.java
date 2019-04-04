import java.util.Scanner;
public class MileToKmConverter {

    public static void main(String[] args) {
        // Write a program that asks for an integer that is a distance in kilometers,
        // then it converts that value to miles and prints it
        double kmToMile = 0.6213;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many kilometeres do you run per week?");
        double distanceInMiles = myScanner.nextInt() * kmToMile;

        System.out.println("That is exactly " + distanceInMiles + " miles!");


    }
}
