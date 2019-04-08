package euler.solutions;

// Find the difference between the sum of the squares of the first one hundred natural numbers and
// the square of the sum.
public class Solution006 {

  public static String getAnswer() {
    int sumOfSquares = 0;
    int squareOfSums = 0;
    for (int i = 1; i <= 100; i++) {
      sumOfSquares += i * i;
      squareOfSums += i;
    }
    squareOfSums = squareOfSums * squareOfSums;
    return Integer.toString(squareOfSums - sumOfSquares);
  }
}
