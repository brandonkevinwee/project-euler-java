package euler.solutions;

// What is the sum of the numbers on the diagonals in a 1001 by 1001 number spiral?
public class Solution028 {

  public static String getAnswer() {
    int runningSum = 1;
    for (int i = 3; i <= 1001; i = i + 2) {
      runningSum += solveThroughMathematics(i);
    }
    return Integer.toString(runningSum);
  }

  // 1+summation(4n^2-6n+6) for odd values of n
  private static int solveThroughMathematics(int dimension) {
    return 4 * dimension * dimension - 6 * dimension + 6;
  }
}
