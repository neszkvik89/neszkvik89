public class NumberAdder {

    public static void main(String[] args) {
        System.out.println(numberAdder(8, 0));

    }

    public static int numberAdder(int n, int sum) {



        if (n > 0) {
            sum += n;
            n--;
            numberAdder(n, sum);
        }
        return sum;

    }
}
