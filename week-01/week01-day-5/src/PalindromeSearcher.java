import java.util.Scanner;

public class PalindromeSearcher {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please give me a long word");
        String theWord = myScanner.next();
        String [] palindromes = new String[100];
        int posCounter = 0;
        int midDif = 1;


 /*       for (int j = theWord.length() - 4; j > 0; j--) {
            for (int i = theWord.length() - 2; i > 1; i--) {
                if (theWord.charAt(i - midDif) == theWord.charAt(i + midDif)) {
                    String aPalindrome = "";
                    aPalindrome = aPalindrome + theWord.substring(i - midDif, i + midDif + 1);
                    palindromes[posCounter] = aPalindrome;
                    posCounter++;
                    midDif++;
                    System.out.println("belső kör");
                    System.out.println(aPalindrome);
                }
                System.out.println("külső kör");
            }
            System.out.println("legkülső kör???");

        }
*/



        for (int j = theWord.length() - 2; j > 1; j--) {
            for (int i = theWord.length() - 2; i > 1; i--) {
                if (theWord.charAt(i) == theWord.charAt(i - 1)) {

                    System.out.println("Two similar characters detected next to each other");
                    for (int k = theWord.length() - j - 1; k > theWord.length() / 2; k--) {
                        if (theWord.charAt(i + k) == theWord.charAt(i - k)) {
                            String anEvenPalindrome = "";
                            anEvenPalindrome = anEvenPalindrome + theWord.substring(i - k, i + k + 1);
                            palindromes[posCounter] = anEvenPalindrome;
                            posCounter++;
                            System.out.println(anEvenPalindrome + "was found");
                        }
                        else break;
                    }
                }
            }
            System.out.println("legkülső kör???");

        }

    }
}
