
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) {
        try {
            Path myPath = Paths.get("src/my-file.txt");
            List<String> myLines = Files.readAllLines(myPath);
            System.out.println(myLines);
        } catch (IOException exc01) {
            System.out.println("Unable to read file: my-file.txt");}
    }
}
