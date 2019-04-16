import java.io.*;


public class WriteSingleLine {
    public static void main(String[] args) {
  lineWriter();
    }

    public static void lineWriter(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/my-file.txt", true));
            bw.write("Fekete Attila");
            bw.close();
        } catch (IOException e) {
            System.out.println("Unable to write file: my-file.txt");
        }

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("src/my-file.txt"));

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
