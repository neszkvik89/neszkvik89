import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        whoWins("src/owin.txt");
    }

    public static void whoWins(String path) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        String[] ipList = new String[500];
        String[] lines = new String[3];
        int i = 0;
        boolean oWins = false;
        boolean xWins = false;

        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            for (int h = 0; h < 3; h++){
                String line = sc.nextLine();
                lines[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        for (int k = 0; k < 3; k++) {
            if (lines[0].charAt(k) == lines[1].charAt(k) && lines[0].charAt(k) == lines[2].charAt(k)) {
                if (lines[0].charAt(k) == 'o') {
                    oWins = true;
                    System.out.println("o");
                    break;
                } else {
                    xWins = true;
                    System.out.println("x");
                    break;
                }
            }

            if (lines[0].charAt(0) == lines[1].charAt(1) && lines[0].charAt(0) == lines[2].charAt(2)) {
                if (lines[0].charAt(0) == 'o') {
                    oWins = true;
                    System.out.println("o");
                    break;
                } else {
                    xWins = true;
                    System.out.println("x");
                    break;
                }
            }

            if (lines[0].charAt(2) == lines[1].charAt(1) && lines[0].charAt(2) == lines[2].charAt(0)) {
                if (lines[0].charAt(2) == 'o') {
                    oWins = true;
                    System.out.println("o");
                    break;
                } else {
                    xWins = true;
                    System.out.println("x");
                    break;
                }
            }
        }
        if (oWins == false && xWins == false) {
            System.out.println("Draw");
        }
    }
}
