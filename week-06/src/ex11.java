import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ex11 {
  public static void main(String[] args) {
    try {
      mostCommonWords("src/text.txt");
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }

  public static HashMap<String, Integer> mostCommonWords (String fileLocation) throws IOException {
    HashMap<String, Integer> myMap = new HashMap<>();
    List<Character> toAvoid = Arrays.asList(';', '.', ',', ':', '[', ']', '(', ')');
    List<String> wordsInTheText = new ArrayList<>();
    Path filePath = Paths.get(fileLocation);
    Path secondFilePath = Paths.get("src/text2.txt");
    String theWholeText = Files.readString(filePath);
    StringBuilder sb = new StringBuilder();


    for (int i = 0; i < theWholeText.length(); i++) {
      if (!toAvoid.contains(theWholeText.charAt(i))) {
        sb.append(theWholeText.charAt(i));
      }
    }

    theWholeText = sb.toString();
    Files.writeString(secondFilePath, theWholeText);
    Scanner sc = new Scanner(secondFilePath);
    sc.useDelimiter(" ");
    while (sc.hasNext()) {
      wordsInTheText.add(sc.next());
    }



    for (int i = 0; i < wordsInTheText.size(); i++) {
      if (myMap.containsKey(wordsInTheText.get(i))) {
        myMap.replace(wordsInTheText.get(i), myMap.get(wordsInTheText.get(i)) + 1);
      } else {
        myMap.put(wordsInTheText.get(i), 1);
      }
    }

    System.out.println(myMap.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toList()));
    return myMap;
  }
}
