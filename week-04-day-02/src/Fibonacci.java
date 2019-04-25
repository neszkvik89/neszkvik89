public class Fibonacci {

    public int fibo(int prev1, int prev2, int n, int sum) {
        for (int i = 0; i < n - 2; i++) {
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Fibonacci myFibObject = new Fibonacci();
        System.out.println(myFibObject.fibo(0, 1, 9, 1));

    }
}
