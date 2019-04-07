import java.util.Scanner;

public class JosephusProblem {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("How many players are there?");
        int players = myScanner.nextInt();
        int rotator = 1;

        int [] seats = new int [players];
        int [] seatsLeft;

        for (int i = 0; i < seats.length; i++) {
            seats [i] = i + 1;
        }


        for (int i = 0; i < seats.length; i++) {
            if (seats [i] != 0) {
                seats [i+1] = 0;
                }
            }





            for (int j = 0; j < seats.length; j++) {
                System.out.println(seats [j]);
            }

        }
    }

