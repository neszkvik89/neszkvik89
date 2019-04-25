import java.util.Arrays;

public class Anagram {

    public boolean anagramFinder (String firstWord, String secondWord) {
        boolean isAnagram = (firstWord.length() != secondWord.length());
        char [] firstOne = firstWord.toCharArray();
        char [] secondOne = secondWord.toCharArray();
        Arrays.sort(firstOne);
        Arrays.sort(secondOne);

        String firstSorted = new String(firstOne);
        String secondSorted = new String(secondOne);
        isAnagram = firstSorted.equals(secondSorted);
        return isAnagram;
    }
}
