public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibo(0, 1, 9, 0, 3));

    }

    public static int fibo(int prev1, int prev2, int n, int sum, int counter) {
        if (counter < n + 1) {
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
            counter++;
            fibo(prev1, prev2, n, sum, counter);
        }
        System.out.println(sum);
        return sum;
    }
}
