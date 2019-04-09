import java.util.ArrayList;

public class PersonalFInance {

    public static void main(String[] args) {
        ArrayList <Integer> myExpenses = new ArrayList<>();
        myExpenses.add(500);
        myExpenses.add(1000);
        myExpenses.add(1250);
        myExpenses.add(175);
        myExpenses.add(800);
        myExpenses.add(120);

        int totalSpent = 0;
        int greatestAmount = 0;
        int smallestAmount = Integer.MAX_VALUE;

        for (int i = 0; i < myExpenses.size(); i++) {
            totalSpent += myExpenses.get(i);
            if (myExpenses.get(i) > greatestAmount) {
                greatestAmount = myExpenses.get(i);
            }

            if (myExpenses.get(i) < smallestAmount) {
                smallestAmount = myExpenses.get(i);
            }
        }
        System.out.println("We spent a grand total of " + totalSpent);
        System.out.println("Our greatest expense was " + greatestAmount);
        System.out.println("Our smallest expense was " + smallestAmount);
        System.out.println("Our average expense was " + totalSpent / myExpenses.size());


    }
}
