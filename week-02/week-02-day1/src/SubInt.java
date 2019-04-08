public class SubInt {

    public static void main(String[] args) {

        SubInt(2, new int[] {2, 43, 78, 22});

    }

    public static int[] SubInt (int a, int [] aArray) {
        String theNumber = String.valueOf(a);
        String [] numbers = new String [aArray.length];
        int contains = 0;

        for (int i = 0; i <aArray.length; i++) {
            numbers[i] = String.valueOf(aArray[i]);
            if (numbers[i].contains(theNumber)) {
                contains++;
            }
        }

        int [] indexes = new int[contains];
        int theIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].contains(theNumber)) {
                indexes [theIndex] = Integer.valueOf(numbers[i]);
                theIndex++;
            }
        }
        return indexes;
    }
}
