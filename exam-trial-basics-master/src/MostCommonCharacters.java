import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class MostCommonCharacters {

  HashMap<Character, Integer> letterMap = new HashMap<>();

  public String findMostCommon(String path) {

    String toReturn = "";

    try {
      Path filePath = Paths.get("src/text.txt");
      List<String> lines = Files.readAllLines(filePath);
      char mostFreq = 0;
      char mostFreq2 = 0;

      for (int i = 0; i < lines.size(); i++) {
        for (int j = 0; j < lines.get(i).length(); j++) {
          if (letterMap.containsKey(lines.get(i).charAt(j))) {
            letterMap.replace(lines.get(i).charAt(j), letterMap.get(lines.get(i).charAt(j)) + 1);
            if (letterMap.get(lines.get(i).charAt(j)) + 1 > mostFreq) {
              mostFreq = lines.get(i).charAt(j);
            } else if (letterMap.get(lines.get(i).charAt(j)) + 1 > mostFreq2) {
              mostFreq2 = lines.get(i).charAt(j);
            }
          } else {
            letterMap.put((lines.get(i).charAt(j)), 1);
          }
        }
      }
      toReturn = mostFreq + " : " + letterMap.get(mostFreq) + ", " + mostFreq2 + " : " + letterMap.get(mostFreq2);
    } catch (Exception e) {
      System.out.println("Uh-oh, could not read the file!");
    }
    return toReturn;
  }


  public static void main(String[] args) {
    MostCommonCharacters myTest = new MostCommonCharacters();
    System.out.println(myTest.findMostCommon("text.txt"));
  }
}
