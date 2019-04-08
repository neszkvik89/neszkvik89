public class Factorio {

    public static void main(String[] args) {
        int factor = 5;
        System.out.println(produce(factor));
    }

    public static int produce(int factor) {
        int sum = 1;
        for (int i = 1; i < factor + 1; i++) {
            sum *= i;
        }
        return sum;
    }
}
