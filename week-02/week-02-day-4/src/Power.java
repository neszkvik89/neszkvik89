public class Power {

    public static void main(String[] args) {

        power(2, 4, 1);

    }

    public static int power (int base, int power, int sum) {
        if (power > 0) {
            sum *= base;
            power--;
            power(base, power, sum);
        }
        System.out.println(sum);
        return sum;
    }
}
