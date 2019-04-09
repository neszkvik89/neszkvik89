import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ProductDatabase {

    public static void main(String[] args) {
        HashMap <String, Integer> myMap = new HashMap<>();
        myMap.put("Eggs", 200);
        myMap.put("Milk", 200);
        myMap.put("Fish", 400);
        myMap.put("Apples", 150);
        myMap.put("Bread", 50);
        myMap.put("Chicken", 550);

        //kind of cheating here with a reverse hash-map
        HashMap <Integer, String> myMap2 = new HashMap<>();
        myMap2.put(200, "Eggs");
        myMap2.put(200, "Milk");
        myMap2.put(400, "Fish");
        myMap2.put(150, "Apples");
        myMap2.put(50, "Bread");
        myMap2.put(550, "Chicken");

        System.out.println(myMap.get("Fish"));

        int mostExp = 0;
        String mostExpItem = "";
        int cheapest = Integer.MAX_VALUE;
        String cheapestItem = "";
        int sum = 0;
        int below300 = 0;
        boolean is125 = false;

        for (Map.Entry mapElem : myMap.entrySet()) {
            sum += (Integer) mapElem.getValue();
            if ((Integer) mapElem.getValue() > mostExp) {
                mostExp = (Integer) mapElem.getValue();
                mostExpItem = (String) mapElem.getKey();
            }

            if ((Integer) mapElem.getValue() < cheapest) {
                cheapest = (Integer) mapElem.getValue();
                cheapestItem = (String) mapElem.getKey();
            }

            if ((Integer) mapElem.getValue() < 300) {
                below300++;
            }

            if ((Integer) mapElem.getValue() == 125) {
                is125 = true;
            }
        }
        double avg = (double) sum / myMap.size();

        System.out.println("Total price is " + sum);
        System.out.println("Most expensive is " + mostExpItem);
        System.out.println("Cheapest is " + cheapestItem);
        System.out.println("Average is " + avg);
        System.out.println("There are " + below300 + " items below 300");
        System.out.println(is125);
    }
}
