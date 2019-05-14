import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ex9 {
  public static void main(String[] args) {
    System.out.println(occuranceTracker("kutyámajom").entrySet());
  }

  //using streams just overcomplicates it for me, so decided against it
  public static HashMap<Character, Integer> occuranceTracker (String myString) {
    HashMap<Character, Integer> myMap = new HashMap<>();
    for (int i = 0; i < myString.length(); i++) {
      if (!myMap.containsKey(myString.charAt(i))) {
        myMap.put(myString.charAt(i), 1);
      } else {
        myMap.replace(myString.charAt(i), myMap.get(myString.charAt(i)) + 1);
      }
    }
    return myMap;
  }
}
