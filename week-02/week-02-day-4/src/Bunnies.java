public class Bunnies {

    public static void main(String[] args) {

        System.out.println(bunnyCounter(32, 0));

    }

    public static int bunnyCounter(int bunnyNr, int sum) {
        if (bunnyNr > 0) {
            sum += 2;
            bunnyNr--;
            bunnyCounter(bunnyNr, sum);
        }
        System.out.println(sum);
        return sum;
    }
}
