import java.util.HashMap;

public class CountLetters {
    public HashMap<Character, Integer> dictionary (String toMap) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        HashMap<Character, Integer> testMap = new HashMap<>();

        for (int i = 0; i < toMap.length(); i++) {
            if (!myMap.containsKey(toMap.charAt(i))) {
                myMap.put(toMap.charAt(i), 1);
            } else {
                myMap.replace(toMap.charAt(i), myMap.get(toMap.charAt(i)) + 1);
            }
        }
        return myMap;
    }

    public static void main(String[] args) {
        CountLetters myCounter = new CountLetters();
        System.out.println(myCounter.dictionary("kutyámajmokkal"));
    }
}
