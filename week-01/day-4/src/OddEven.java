import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please type in an integer then press Enter");
        boolean even = myScanner.nextInt() % 2 == 0;
        if (even == true)  {

            System.out.println("Even");

        } else {
            System.out.println("Odd");
        }


    }
}


