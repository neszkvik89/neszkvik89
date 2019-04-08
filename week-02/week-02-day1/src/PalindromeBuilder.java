public class PalindromeBuilder {

    public static void main(String[] args) {

        System.out.println(palindromeBuilder("görög"));

    }

    public static String palindromeBuilder (String aWord) {
        StringBuilder myBuilder = new StringBuilder(aWord);

        for (int i = aWord.length()-1; i > -1; i--) {
            myBuilder.append(aWord.charAt(i));
        }

        return myBuilder.toString();
    }
}
