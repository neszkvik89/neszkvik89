import java.util.Arrays;

public class AnagramWithArrays {

    public static void main(String[] args) {

        System.out.println(isAnagram("görög", "öörgg"));
        }

        public static boolean isAnagram (String firstWord, String secondWord){

            char[] firstOne = firstWord.toCharArray();
            char[] secondOne = secondWord.toCharArray();
            Arrays.sort(firstOne);
            Arrays.sort(secondOne);
            String firstSorted = new String(firstOne);
            String secondSorted = new String(secondOne);
            boolean isAnagram = firstSorted.equals(secondSorted);
            return isAnagram;

        }
    }
