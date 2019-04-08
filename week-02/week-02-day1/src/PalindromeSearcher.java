public class PalindromeSearcher {

    public static void main(String[] args) {

        allPalindromes("rtomoppotukut");
    }

    public static int amountOfPalindromes(String str) {
        int palindromeCounter = 0;
        for (int i = 0; i <= str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
            } else {
                palindromeCounter++;
            }
        return palindromeCounter;
    }

    public static String[] allPalindromes(String str) {
        String[] palindromeArray = new String[1000];
        int palPos = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String test = "";
                test = (str.substring(i, j));
                boolean isPalindrome = false;
                if (test.length() % 2 == 0) {
                    for (int k = 0; k <= test.length() / 2; k++) {
                        if (test.charAt(k) != test.charAt(test.length() - 1 - k)) {
                            isPalindrome = false;
                            break;

                        } else if (test.length() > 2) {
                            isPalindrome = true;

                        } else isPalindrome = false;
                    }
                    if (isPalindrome == true) {
                        palindromeArray[palPos] = test;
                        System.out.println(palindromeArray[palPos]);
                        palPos++;
                    }
                } else {
                    for (int k = 0; k <= test.length() / 2 - 1; k++) {
                        if (test.charAt(k) != test.charAt(test.length() - 1 - k)) {
                            break;

                        } else if (test.length() > 2) {
                            isPalindrome = true;
                        } else isPalindrome = false;
                    }
                    if (isPalindrome == true) {
                        palindromeArray[palPos] = test;
                        System.out.println(palindromeArray[palPos]);
                        palPos++;
                    }
                }
            }
        }
        return palindromeArray;
    }
}
