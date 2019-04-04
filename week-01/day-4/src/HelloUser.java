import java.util.Scanner;
public class HelloUser {

    public static void main(String[] args) {
        // Modify this program to greet user instead of the World!
        // The program should ask for the name of the user
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please type in your name and press Enter");
        String userName = myScanner.next();
        System.out.println("Hello, " + userName + "!");
    }

}
