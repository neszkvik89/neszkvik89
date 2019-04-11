public class StringsAgain {

    public static void main(String[] args) {

        xySwap("kuxoypxxy", 1);

    }



    public static String xySwap (String theWord, int length) {
        if (length < theWord.length() && theWord.contains("x")) {
            if (theWord.charAt(length - 1) == 120) {theWord = theWord.replace("x", "");}

            length++;
            xySwap(theWord, length);
        }
        System.out.println(theWord);
        return theWord;
    }
}
