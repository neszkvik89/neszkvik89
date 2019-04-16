import java.io.*;

public class WriteMultipleLines {
    public static void main(String[] args) {
  multiWriter("src/my-text.txt", "egyszó", 4);
    }

    public static void multiWriter(String path, String theWord, int times) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/my-text.txt", true));
            for (int i = 0; i < times; i++) {
                bw.write(theWord + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println();
        }

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("src/my-text.txt"));

            String myString;
            while ((myString = in.readLine()) != null) {
                System.out.println(myString);
            }
        }
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }
}
