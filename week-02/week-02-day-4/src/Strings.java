public class Strings {

    public static void main(String[] args) {

        xySwap("kuxoypxxy", 1);

    }



    public static String xySwap (String theWord, int length) {
        if (length < theWord.length()) {
            if (theWord.charAt(length - 1) == 120) {theWord = theWord.replace('x', 'Y');}
            if (theWord.charAt(length - 1) == 121) {theWord = theWord.replace('y', 'X');}

            length++;
            xySwap(theWord, length);
        }
        System.out.println(theWord.toLowerCase());
        return theWord;
    }
}
