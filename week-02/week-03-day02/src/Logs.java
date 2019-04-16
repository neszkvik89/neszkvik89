import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Logs {
    public static void main(String[] args) {
        System.out.println(getPostRatio());
        getIpArray();
    }

    public static double getPostRatio() {
        int post = 0;
        int get = 0;
        FileInputStream inputStream = null;
        Scanner sc = null;
        String [] ipList = new String [500];

        try {
            Path path = Paths.get("src/logs.txt");
            inputStream = new FileInputStream("src/logs.txt");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("POST")) {
                    post++;
                } else {
                    get++;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return ((double) get / (double) post);
    }

    public static String[] getIpArray() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        String [] ipList = new String [500];
        int i = 0;

        try {
            Path path = Paths.get("src/logs.txt");
            inputStream = new FileInputStream("src/logs.txt");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ipList[i] = line.substring(27, 38);
                i++;
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return ipList;
    }
}
