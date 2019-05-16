import java.util.Arrays;

public class MatrixMultiplier {

  public static int [][] matrixMulti (int [][] my2DArray) {
    for (int i = 0; i < my2DArray.length; i++) {
      for (int k = 0; k < my2DArray[0].length; k++) {
        if (my2DArray[i][k] % 2 == 0 && i % 2 == 0) {
          my2DArray[i][k] *= 2;
        } else if (my2DArray[i][k] % 2 != 0 && i % 2 != 0) {
          my2DArray[i][k] *= 2;
        }
      }
    }
    return my2DArray;
  }
  public static void main(String[] args) {

    int [][] myTestArray = new int [][] {
        { 1, 3, 6, 2,},
        { 7, 5, 6, 1,},
        { 3, 3, 1, 5,},
        { 9, 0, 5, 3,},
    };
    System.out.println(Arrays.deepToString(matrixMulti(myTestArray)));
  }
}
