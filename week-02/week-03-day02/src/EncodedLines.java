import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncodedLines {
    public static void main(String[] args) {
        System.out.println(decrypt());
    }

    public static String decrypt() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder solved = new StringBuilder();

        try {
            Path path = Paths.get("src/encoded-lines.txt");
            inputStream = new FileInputStream("src/encoded-lines.txt");
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        solved.append((char) (line.charAt(i) - 1));
                    } else {
                        solved.append(" ");
                    }
                }
                solved.append("\n");
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return solved.toString();
    }
}
