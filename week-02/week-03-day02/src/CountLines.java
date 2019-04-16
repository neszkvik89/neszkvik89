import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        System.out.println(countThem("src/my-file.tx"));
    }

    public static int countThem(String theFile) {
        try {
            Path myPath = Paths.get(theFile);
            List<String> lines = Files.readAllLines(myPath);
            return lines.size();
        } catch (IOException exc01) {
            return 0;
        }
    }
}
