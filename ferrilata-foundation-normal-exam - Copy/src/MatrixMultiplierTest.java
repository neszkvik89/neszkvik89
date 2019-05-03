import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixMultiplierTest {

  @Test
  public void matrixMultiTestWithNegatives() {
    int[][] myTestArray = new int[][]{
        {-1, 3, 6, 2,},
        {7, -5, 6, 1,},
        {6, 3, 1, -8,},
        {9, 0, 4, 3,},
    };

    MatrixMultiplier.matrixMulti(myTestArray);

    int[][] expected = new int[][]{
        {-1, 3, 12, 4,},
        {14, -10, 6, 2,},
        {12, 3, 1, -16,},
        {18, 0, 4, 6,},
    };
    assertArrayEquals(myTestArray, expected);
  }

  @Test
  public void MatrixMultiWithEmptyArray() {
    int[][] myTestArray2 = new int[0][0];
    MatrixMultiplier.matrixMulti(myTestArray2);
    int[][] expected2 = new int[0][0];
    assertArrayEquals(expected2, myTestArray2);
  }
}