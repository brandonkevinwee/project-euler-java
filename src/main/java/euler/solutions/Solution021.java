package euler.solutions;

// Evaluate the sum of all the amicable numbers under 10000.
public class Solution021 {

  public static String getAnswer() {
    int runningSum = 0;
    for (int i = 1; i <= 10000; i++) {
      int firstSum = sumOfDivisors(i);
      if (sumOfDivisors(firstSum) == i && i != firstSum) runningSum += i;
    }
    return Integer.toString(runningSum);
  }

  private static int sumOfDivisors(int evaluate) {
    int runningSum = 0;
    for (int i = 1; i <= evaluate / 2; i++) {
      if (evaluate % i == 0) runningSum += i;
    }
    return runningSum;
  }
}
