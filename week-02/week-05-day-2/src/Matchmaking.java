import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Matchmaking {

    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));



        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // If someone has no pair, he/she should be the element of the list too
        // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

        System.out.println(makingMatches(girls, boys));
    }

    public static ArrayList <String> makingMatches (ArrayList girls, ArrayList boys) {

        int length = girls.size() + boys.size();
        ArrayList <String> matches = new ArrayList<>();



        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                matches.add((String)boys.get(i/2));
            } else {
                matches.add((String)girls.get(i/2));
            }
        }
        return matches;
    }
}
