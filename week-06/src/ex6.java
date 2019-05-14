import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ex6 {
  public static void main(String[] args) {
    String testString = "kUtyámAJOm";
    List<Character> testChars = new ArrayList<>();
    for (int i = 0; i < testString.length(); i++) {
      testChars.add(testString.charAt(i));
    }
    System.out.println(testChars.stream()
        .filter(n -> n.toString().toUpperCase().equals(n.toString()))
        .collect(Collectors.toList()));
  }
}
