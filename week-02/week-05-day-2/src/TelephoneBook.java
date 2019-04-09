import java.util.HashMap;

public class TelephoneBook {

    public static void main(String[] args) {
        HashMap <String, String> myMap = new HashMap<>();
        myMap.put("William A. Lathan", "405-709-1865");
        myMap.put("John K. Miller", "402-247-8568");
        myMap.put("Hortensia E. Foster", "606-481-6467");
        myMap.put("Amanda D. Newland", "319-243-5613");
        myMap.put("Brooke P. Askew", "307-687-2982");

        HashMap <String, String> myMap2 = new HashMap<>();
        myMap2.put("405-709-1865", "William A. Lathan");
        myMap2.put( "402-247-8568", "John K. Miller");
        myMap2.put( "606-481-6467", "Hortensia E. Foster");
        myMap2.put( "319-243-5613", "Amanda D. Newland");
        myMap2.put( "307-687-2982", "Brooke P. Askew");

        System.out.println(myMap.get("John K. Miller"));
        System.out.println(myMap2.get("307-687-2982"));
        System.out.println(myMap.containsKey("Chris E. Myer"));

    }
}
