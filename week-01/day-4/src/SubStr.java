import java.util.Scanner;


public class SubStr {

    public static void main(String[] args) {

        System.out.println(subStr("gólyaláb", "láb"));
        System.out.println(subStr("kisnyúl", "béla"));

    }

    public static int subStr(String input, String q) {

        boolean contains = input.contains(q);
        int startingPos = -1;
        if (contains == true) {
            startingPos = input.indexOf(q);
        } else {
            return startingPos;
        }

        return startingPos;

    }
}
