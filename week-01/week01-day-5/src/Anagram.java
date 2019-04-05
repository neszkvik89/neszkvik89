import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please give me a word");
        String firstWord = myScanner.next().toLowerCase();
        System.out.println("Please give me another word");
        String secondWord = myScanner.next().toLowerCase();

        boolean isAnagram = (firstWord.length() != secondWord.length());
        char [] firstOne = firstWord.toCharArray();
        char [] secondOne = secondWord.toCharArray();
        Arrays.sort(firstOne);
        Arrays.sort(secondOne);

        String firstSorted = new String(firstOne);
        String secondSorted = new String(secondOne);

        isAnagram = firstSorted.equals(secondSorted);
        System.out.println(isAnagram);
    }



}
