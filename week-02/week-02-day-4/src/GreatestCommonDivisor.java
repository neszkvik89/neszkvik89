import java.util.ArrayList;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        greatest(144, 74, 1, 1);

    }

    public static int greatest (int num1, int num2, int aDivisor, int theGreatest) {

        int smallerNumber = 0;
        int biggerNumber = 0;
        if (num1 < num2) {
            smallerNumber = num1;
            biggerNumber = num2;
        } else {
            smallerNumber = num2;
            biggerNumber = num1;
        }

        if (aDivisor <= smallerNumber) {

            if (smallerNumber % aDivisor == 0 && biggerNumber % aDivisor == 0) {
                theGreatest = aDivisor;
            }
            aDivisor++;
            greatest(num1, num2, aDivisor, theGreatest);
        }
        System.out.println(theGreatest);
        return theGreatest;
    }
}
