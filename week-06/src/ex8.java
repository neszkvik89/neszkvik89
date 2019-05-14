import java.util.Arrays;
import java.util.List;

public class ex8 {
  public static void main(String[] args) {
    List<Character> charToConnect = Arrays.asList('k', 'u', 't', 'y', 'á', 'm', 'a', 'j', 'o', 'm');
    System.out.println(connectToString(charToConnect));
  }

  public static String connectToString(List<Character> myChars) {
    StringBuilder sb = new StringBuilder();
    myChars.stream().forEach(n -> sb.append(n));
    return sb.toString();
  }
}
