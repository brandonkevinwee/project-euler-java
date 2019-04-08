package euler.solutions;

// How many routes are there through a 20×20 grid?
public class Solution015 {

  public static String getAnswer() {
    int column = 20;
    int row = 20;
    long[][] latticeGrid = new long[row + 1][column + 1];
    for (int i = 0; i <= column; i++) {
      latticeGrid[i][column] = 1;
    }
    for (int i = 0; i <= row; i++) {
      latticeGrid[row][i] = 1;
    }
    for (int i = row - 1; i >= 0; i--) {
      for (int j = column - 1; j >= 0; j--) {
        latticeGrid[i][j] = latticeGrid[i][j + 1] + latticeGrid[i + 1][j];
      }
    }
    return Long.toString(latticeGrid[0][0]);
  }
}
