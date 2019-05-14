import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex7 {
  public static void main(String[] args) {

    ex7 myEx7 = new ex7();
    System.out.println(myEx7.filteredCities('L'));

  }

  public List<String> filteredCities(char c) {
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    return cities.stream()
        .filter(n -> n.startsWith(String.valueOf(c)))
        .collect(Collectors.toList());
  }
}
