public class MaximumFinder {

    public static void main(String[] args) {
        System.out.println(maxFinder(new int [] {31, 2, 24, 5, 9, 14}, 0, Integer.MIN_VALUE ));
    }

    public static int maxFinder(int [] numbers, int counter, int greatest) {
        if (counter < numbers.length) {
            if (numbers[counter] > greatest) {
                greatest = numbers[counter];
            }
            counter++;
            maxFinder(numbers, counter, greatest);
        }
        return greatest;
    }
}
