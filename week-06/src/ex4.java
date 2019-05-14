import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex4 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    int oddSum = 0;
    List<Integer> oddNumbers = numbers.stream()
        .filter(n -> n % 2 != 0)
        .collect(Collectors.toList());

    for (int i = 0; i < oddNumbers.size(); i++) {
      oddSum += oddNumbers.get(i);
    }
    System.out.println(oddSum/oddNumbers.size());
  }
}
