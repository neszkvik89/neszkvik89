import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lottery {
    public static void main(String[] args) {
        System.out.println(decrypt());
    }

    public static int decrypt() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder solved = new StringBuilder();
        ArrayList <Integer> allNumbers = new ArrayList<>();

        try {
            Path path = Paths.get("src/lottery.txt");
            inputStream = new FileInputStream("src/lottery.txt");
            sc = new Scanner(inputStream, "UTF-8");
            String[] fiveNumbers = new String[3065];

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                fiveNumbers = (line.split(";"));
                allNumbers.add(Integer.valueOf(fiveNumbers[11]));
                allNumbers.add(Integer.valueOf(fiveNumbers[12]));
                allNumbers.add(Integer.valueOf(fiveNumbers[13]));
                allNumbers.add(Integer.valueOf(fiveNumbers[14]));
                allNumbers.add(Integer.valueOf(fiveNumbers[15]));
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        Collections.sort(allNumbers);

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : allNumbers) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        int k = -10;
        int highestOcc = 1;
        for(int i = 1; i < 91; i++) {
            System.out.println(map.get(i));
            if (map.get(i) > highestOcc) {
                highestOcc = map.get(i);
                k = i;
            }
        }
        return k;
    }
}
