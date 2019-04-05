import java.util.Scanner;

public class PalindromeSearcher {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please give me a long word");
        String theWord = myScanner.next();
        String [] palindromes = new String[100];
        int posCounter = 0;
        int midDif = 1;

        for (int j = theWord.length() -4; j > 0; j--) {
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

        System.out.println(palindromes[0]);
        System.out.println(palindromes[1]);
        System.out.println(palindromes[2]);
        System.out.println(palindromes[3]);
        System.out.println(palindromes[4]);
        System.out.println(palindromes[5]);
        System.out.println(palindromes[6]);
        System.out.println(palindromes[7]);
        System.out.println(palindromes[8]);
        System.out.println(palindromes[9]);
        System.out.println(palindromes[10]);
        System.out.println(palindromes[11]);




    }
}
