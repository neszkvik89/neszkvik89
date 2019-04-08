public class Matrix {

    public static void main(String[] args) {
        int [] [] matrix = new int [4] [4];
        int onePos = 0;

        for (int i = 0; i < matrix.length; i++)  {
            for (int j = 0; j < matrix.length; j++) {
                if (j == onePos) {
                    matrix [i] [j] = 1;
                }

                else {
                    matrix [i] [j] = 0;
                }
            }
            onePos++;
        }
        System.out.println(matrix [1] [2]);
    }
}
