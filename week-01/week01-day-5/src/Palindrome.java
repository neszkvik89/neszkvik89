import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me a word");
        String theWord = myScanner.next();

        int strLength = theWord.length();
        String palindrome = "";

        for (int i = strLength -1; i > -1; i--) {
            palindrome = palindrome + theWord.charAt(i);
        }
        System.out.println(palindrome);

    }
}
