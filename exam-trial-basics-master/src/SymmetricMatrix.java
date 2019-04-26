public class SymmetricMatrix {

  public boolean isToReturn() {
    return toReturn;
  }

  public void setToReturn(boolean toReturn) {
    this.toReturn = toReturn;
  }

  boolean toReturn = true;

  public SymmetricMatrix() {
  }

  public boolean isSymmetric(int [][] my2dArray) {
    for (int i = 1; i < my2dArray.length; i++) {
      if (my2dArray[i][i-1] != my2dArray[i-1][i]) {
        this.setToReturn(false);
        break;
      } else if (my2dArray[my2dArray.length - i][my2dArray.length - i - 1]
          != my2dArray[my2dArray.length - i - 1][my2dArray.length - i]) {
        this.setToReturn(false);
        break;
      }
    } return this.isToReturn();
  }

  public static void main(String[] args) {
    SymmetricMatrix myMatrix = new SymmetricMatrix();
    int [][] testMatrix = new int [3][3];
    testMatrix[0][0] = 1;
    testMatrix[0][1] = 0;
    testMatrix[0][2] = 1;
    testMatrix[1][0] = 0;
    testMatrix[1][1] = 2;
    testMatrix[1][2] = 2;
    testMatrix[2][0] = 1;
    testMatrix[2][1] = 2;
    testMatrix[2][2] = 5;

    System.out.println(myMatrix.isSymmetric(testMatrix));
  }
}
