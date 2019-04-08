public class Sum {

    public static void main(String[] args) {
        int lastOne = 5;
        System.out.println(summing(lastOne));
    }

    public static int summing (int lastOne) {
        int sum = 0;
        for (int i = 0; i < lastOne + 1; i++) {
            sum += i;
        }
        return sum;
    }
}
