import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {
        advancedBubble(new int [] {3, 43, 8, 24, 53}, false);
    }

    public static int [] bubble (int [] unsList) {
        Arrays.sort(unsList);
        return unsList;
    }

    public  static int [] advancedBubble (int [] unsList, boolean desc) {
        Arrays.sort(unsList);

        if (desc == true) {
        int [] temp = unsList;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = unsList[unsList.length - 1 - i];
        }

            System.out.println(temp[0]);
            System.out.println(temp[1]);
        return temp;

        }
        else {
            System.out.println(unsList[0]);
            System.out.println(unsList[1]);
            return unsList;
        }
    }
}
