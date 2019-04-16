import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReversedOrder {
    public static void main(String[] args) {
        System.out.println(decrypt());
    }

    public static String decrypt() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder solved = new StringBuilder();
        String[] lines = new String[22];
        int i = 21;

        try {
            Path path = Paths.get("src/reversed-order.txt");
            inputStream = new FileInputStream("src/reversed-order.txt");
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines[i] = line;
                i--;
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        for (int j = 0; j < 22; j++) {
            solved.append(lines[j]);
            solved.append("\n");
        }
        return solved.toString();
    }
}
