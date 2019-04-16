import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Doubled {
    public static void main(String[] args) {
        decrypt();
    }

    public static void decrypt() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder solved = new StringBuilder();

        try {
            Path path = Paths.get("src/duplicated-chars.txt");
            inputStream = new FileInputStream("src/duplicated-chars.txt");
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length() - 1; i += 2) {
                    sb.append(line.charAt(i));
                }
                solved.append(sb.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        System.out.println(solved.toString());
    }
}
