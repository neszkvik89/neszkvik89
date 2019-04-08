import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int [] aj = {3, 4, 5, 6, 7};
        int [] temp = new int [aj.length];

        for (int i = 0; i < aj.length; i++) {
            temp [i] = aj[aj.length - i -1];

        }

        for (int j = 0; j < temp.length; j++) {
            aj [j] = temp[j];
            System.out.println(aj[j]);
        }


    }
}
