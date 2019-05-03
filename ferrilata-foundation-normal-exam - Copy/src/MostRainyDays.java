
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class MostRainyDays {

  List<String> lines = new ArrayList<>();
  HashMap<String, Integer> rainyCities = new HashMap<>();

  public String mostRainyCity(String path) throws IOException {

    int maxOccurance = 0;
    String theAnswer = "";
    Scanner sc = new Scanner(new File(path));
    sc.useDelimiter(",");

    while (sc.hasNext()) {
      lines.add(sc.next());
    }

    for (int i = 0; i < lines.size(); i++) {
      if (lines.get(i).contains("RAINY") && rainyCities.containsKey(lines.get(i - 1))) {
        rainyCities.replace(lines.get(i - 1), rainyCities.get(lines.get(i - 1)) + 1);
        if (rainyCities.get(lines.get(i - 1)) > maxOccurance) {
          maxOccurance = rainyCities.get(lines.get(i - 1));
          theAnswer = lines.get(i - 1);
        }
      } else if (lines.get(i).contains("RAINY") && !rainyCities.containsKey(lines.get(i - 1))) {
        rainyCities.put(lines.get(i - 1), 1);
      }
    }
    sc.close();
    System.out.println(rainyCities.entrySet());
    return theAnswer;
  }

  public static void main(String[] args) {

    MostRainyDays myRainyCounter = new MostRainyDays();
    try {
      myRainyCounter.mostRainyCity("src/cities.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
