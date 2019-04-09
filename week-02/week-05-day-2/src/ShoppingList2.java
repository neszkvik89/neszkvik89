import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {

    public static void main(String[] args) {
        HashMap<String, Double> priceList = new HashMap<>();
        priceList.put("Milk", 1.07);
        priceList.put("Rice", 1.59);
        priceList.put("Eggs", 3.14);
        priceList.put("Cheese", 12.6);
        priceList.put("Chicken Breasts", 9.4);
        priceList.put("Apples", 2.31);
        priceList.put("Tomato", 2.58);
        priceList.put("Potato", 1.75);
        priceList.put("Onion", 1.10);

        HashMap<String, Integer> bobList = new HashMap<>();
        bobList.put("Milk", 3);
        bobList.put("Rice", 2);
        bobList.put("Eggs", 2);
        bobList.put("Cheese", 1);
        bobList.put("Chicken Breasts", 4);
        bobList.put("Apples", 1);
        bobList.put("Tomato", 2);
        bobList.put("Potato", 1);

        double bobSum = 0;
        int bobPiece = 0;

        for (Map.Entry mapElement : bobList.entrySet()) {
            bobSum += (Integer) mapElement.getValue() * priceList.get(mapElement.getKey());
            bobPiece += (Integer) mapElement.getValue();
        }

        HashMap<String, Integer> aliceList = new HashMap<>();
        aliceList.put("Rice", 1);
        aliceList.put("Eggs", 5);
        aliceList.put("Chicken Breasts", 2);
        aliceList.put("Apples", 1);
        aliceList.put("Tomato", 10);

        double aliceSum = 0;
        int alicePiece = 0;

        for (Map.Entry mapElem : bobList.entrySet()) {
            aliceSum += (Integer) mapElem.getValue() * priceList.get(mapElem.getKey());
            alicePiece += (Integer) mapElem.getValue();
        }

        System.out.println(bobSum);
        System.out.println(aliceSum);

        if (aliceList.containsKey("Rice") && bobList.containsKey("Rice")) {
            if (bobList.get("Rice") > aliceList.get("Rice")) {
                System.out.println("Bob buys more rice");
            } else if (bobList.get("Rice") == aliceList.get("Rice")) {
                System.out.println("They bought the same amount of rice");
            } else {
                System.out.println("Alice bought more rice");
            }
        }

        if (aliceList.containsKey("Potato") && bobList.containsKey("Potato")) {
            if (bobList.get("Potato") > aliceList.get("Potato")) {
                System.out.println("Bob buys more rice");
            } else if (bobList.get("Rice") == aliceList.get("Rice")) {
                System.out.println("They bought the same amount of rice");
            } else {
                System.out.println("Alice bought more rice");
            }
        }

        if (aliceList.size() > bobList.size()) {
            System.out.println("Alice buys more different products");
        } else if (aliceList.size() < bobList.size()) {
            System.out.println("Bob buys more different products");
        } else {
            System.out.println("They buy the same amount of different products");
        }

        if (bobPiece > alicePiece) {
            System.out.println("Bob bought more pieces of items altogether");
        } else if (bobPiece < alicePiece) {
            System.out.println("Alice bought more pieces of items altogether");
        } else {
            System.out.println("They bought the same amount of items");
        }
    }
}
