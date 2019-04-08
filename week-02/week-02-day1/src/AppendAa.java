public class AppendAa {

    public static void main(String[] args) {
        String [] animals = {"koal", "pand", "zebr"};
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new StringBuilder(animals[i]).append("a")
                                         .toString();
            System.out.println(animals[i]);
        }

    }
}
