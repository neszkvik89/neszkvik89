import java.util.HashMap;
import java.util.Map;

public class MapIntroduction2 {

    public static void main(String[] args) {
        HashMap <String, String> myMap = new HashMap<>();
        myMap.put("978-1-60309-452-8", "A Letter to Jo");
        myMap.put("978-1-60309-459-7", "Lupus");
        myMap.put("978-1-603-09-444-3", "Red Panda and Moon Bear");
        myMap.put("978-1-60309-461-0", "The Lab");

        /*HashMap <String, String> myOtherMap = new HashMap<>();
        myOtherMap.put("A Letter to Jo", "978-1-60309-452-8");
        myOtherMap.put("Lupus" , "978-1-60309-459-7");
        myOtherMap.put("Red Panda and Moon Bear", "978-1-603-09-444-3");
        myOtherMap.put("The Lab", "978-1-60309-461-0"); */

        for (Map.Entry mapElem : myMap.entrySet()) {
            System.out.println(mapElem.getValue() + " (ISBN: " + mapElem.getKey() + ")");
            if (mapElem.getValue() == "The Lab") {
                myMap.remove(mapElem.getKey());
            }
        }

            myMap.remove("978-1-60309-444-3");
            myMap.put("978-1-60309-450-4", "They Called Us Enemy");
            myMap.put("978-1-60309-453-5", "Why Did We Trust Him?");

            System.out.println(myMap.containsKey("478-0-61159-424-8"));
            System.out.println(myMap.get("978-1-60309-453-5"));
        }
    }

