
import java.util.Scanner;
public class AnimalsAndLegs {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        ;
        System.out.println("How many chickens does the farmer have?");
        int chickenLegs = myScanner.nextInt() * 2;

        System.out.println("How many pigs does the farmer have?");
        int pigLegs = myScanner.nextInt() * 4;

        int totalLegs = chickenLegs + pigLegs;

        System.out.println("Then the animals have " + totalLegs +" legs altogether");

    }

}
