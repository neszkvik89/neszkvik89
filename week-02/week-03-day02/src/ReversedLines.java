import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReversedLines {

    public static void main(String[] args) {
        System.out.println(decrypt());
    }

    public static String decrypt() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder solved = new StringBuilder();

        try {
            Path path = Paths.get("src/reversed-lines.txt");
            inputStream = new FileInputStream("src/reversed-lines.txt");
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                StringBuilder b2 = new StringBuilder();
                String line = sc.nextLine();
                line = b2.append(line).reverse().toString();
                solved.append(line);
                solved.append("\n");
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return solved.toString();
    }
}
