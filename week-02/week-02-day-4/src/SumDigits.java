public class SumDigits {

    public static void main(String[] args) {

        sumDigits(4589, 0);

    }

    public static int sumDigits(int number, int sum) {

        String theNumber = String.valueOf(number);
        int size = theNumber.length();


        if (size > 0 && number != 0) {
            sum += number % 10;
            number /= 10;
            sumDigits(number, sum);
            size--;
        }
        System.out.println(sum);
        return sum;

    }
}
