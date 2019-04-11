public class StringsAgainAndAgain {

    public static void main(String[] args) {

        System.out.println(xySwap("kutyák", 0, new StringBuilder()));
    }


    public static String xySwap (String theWord, int length, StringBuilder sb) {
        if (length < theWord.length()) {
            if (theWord.charAt(length) != '*') {
                sb.append(theWord.charAt(length));
                        sb.append('*');

                length++;

                xySwap(theWord, length, sb);
            }
        }

        return sb.toString();
    }
}
