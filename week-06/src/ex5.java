import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex5 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    int oddSum = 0;
    List<Integer> oddFiltered = numbers.stream().filter(n -> n % 2 != 0)
        .collect(Collectors.toList());

    for (int i = 0; i < oddFiltered.size(); i++) {
      oddSum += oddFiltered.get(i);
    }

    System.out.println(oddSum);

  }
}
