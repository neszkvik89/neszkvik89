import java.util.ArrayList;


public class ShoppingList {

    public static void main(String[] args) {
        ArrayList <String> shoppingList = new ArrayList<>();
        shoppingList.add("eggs");
        shoppingList.add("milk");
        shoppingList.add("fish");
        shoppingList.add("apples");
        shoppingList.add("bread");
        shoppingList.add("chicken");

        System.out.println(shoppingList.contains("milk"));
        System.out.println(shoppingList.contains("bananas"));

    }
}
