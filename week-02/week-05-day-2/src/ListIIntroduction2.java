import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ListIIntroduction2 {

    public static void main(String[] args) {
        ArrayList <String> ListA = new ArrayList<>();
        ListA.add("Apple");
        ListA.add("Avocado");
        ListA.add("Blueberries");
        ListA.add("Durian");
        ListA.add("Lychee");

        ArrayList <String> ListB = new ArrayList<>();
        ListA.addAll(ListB);

        System.out.println(ListA.contains("Durian"));
        ListB.remove("Durian");
        ListB.add("Kiwifruit");
        if (ListA.size() > ListB.size()) {
            System.out.println("List A is bigger");
        } else {
            System.out.println("List A is NOT bigger");
        }

        System.out.println(ListA.indexOf("Avocado"));
        System.out.println(ListB.indexOf("Durian"));
        Collections.addAll(ListB, "Passion Fruit", "Pummelo");
        System.out.println(ListA.get(2));
    }
}
