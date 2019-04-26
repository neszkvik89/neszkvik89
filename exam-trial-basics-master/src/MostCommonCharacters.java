import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MostCommonCharacters {

  public static void main(String[] args) {
    MostCommonCharacters myTest = new MostCommonCharacters();
    myTest.findMostCommon("src/text.txt");
  }

  public void findMostCommon(String path) {

    HashMap<Character, Integer> letterMap = new HashMap<>();
    int maxOcc = 0;
    int maxOcc2 = 0;
    String mostCom = "";
    String mostCom2 = "";

    try {
      Path filePath = Paths.get("src/text.txt");
      List<String> lines = Files.readAllLines(filePath);
      BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

      for (int i = 0; i < lines.size(); i++) {
        for (int j = 0; j < lines.get(i).length(); j++) {
          if (letterMap.containsKey(lines.get(i).charAt(j))) {
            letterMap.replace(lines.get(i).charAt(j), letterMap.get(lines.get(i).charAt(j)) + 1);
            if (letterMap.get(lines.get(i).charAt(j)) > maxOcc) {
              maxOcc = letterMap.get(lines.get(i).charAt(j));
            } else if (letterMap.get(lines.get(i).charAt(j)) > maxOcc2) {
              maxOcc2 = letterMap.get(lines.get(i).charAt(j));
            }
          } else {
            letterMap.put((lines.get(i).charAt(j)), 1);
          }
        }
      }

      List<Integer> occurances = new ArrayList<>(letterMap.values());
      Collections.sort(occurances);

      for (Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
        if (letterMap.get(entry.getKey()) == occurances.get(occurances.size() - 1)
            || letterMap.get(entry.getKey()) == occurances.get(occurances.size() - 2)) {
          if (mostCom == "") {
            mostCom = mostCom + (entry);
          } else {
            mostCom2 = mostCom2 + (entry);
          }
        }
      }
      writer.append("\n" + mostCom + ' ' + mostCom2);
      writer.close();
    } catch (Exception e) {
      System.out.println("File does not exist!");
    }
  }
}
