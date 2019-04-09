import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {

    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("Eggs", 200);
        myMap.put("Milk", 200);
        myMap.put("Fish", 400);
        myMap.put("Apples", 150);
        myMap.put("Bread", 50);
        myMap.put("Chicken", 550);

        for (Map.Entry mapElem : myMap.entrySet()) {
            if ( (Integer) mapElem.getValue() < 201) {
                System.out.println(mapElem.getKey() + "costs less than 201");
            }

            if ( (Integer) mapElem.getValue() > 150) {
                System.out.println(mapElem.getKey() + "costs more than 150");
            }

        }

        //Could not figure out how to do this whole thing purely with the hashmap methods.
        /*int [] prices = new int [] {200, 200, 400, 150, 50, 550};
        String [] products = new String [] {"Eggs", "Milk", "Fish", "Apples", "Bread", "Chicken"};

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 201) {
                System.out.println(products[i] + " is cheaper than 201");
            }

            if (prices[i] > 150) {
                System.out.println(products[i] + " costs more than 150");
            }*/
        }

    }

