import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex3 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
    System.out.println(numbers.stream()
        .filter(n -> n * n > 20)
        .collect(Collectors.toList()));
  }
}
