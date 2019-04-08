package euler.solutions;

import java.util.ArrayList;
import java.util.HashSet;

// Find the sum of all the positive integers which cannot be written as the sum of two abundant
// numbers.
public class Solution023 {

  public static String getAnswer() {
    ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
    for (int i = 1; i <= 28123; i++) {
      if (isAbundantNumber(i)) abundantNumbers.add(i);
    }

    HashSet<Integer> sumsOfAbundantNumbers = new HashSet<Integer>();
    for (int abundantNumber : abundantNumbers) {
      for (int abundantNumberTwo : abundantNumbers) {
        int sumOfAbundantNumbers = abundantNumber + abundantNumberTwo;
        if (sumOfAbundantNumbers <= 28123) sumsOfAbundantNumbers.add(sumOfAbundantNumbers);
      }
    }

    int runningSum = 0;
    for (int i = 1; i <= 28123; i++) {
      if (!sumsOfAbundantNumbers.contains(i)) runningSum += i;
    }
    return Integer.toString(runningSum);
  }

  private static boolean isAbundantNumber(int evaluate) {
    int runningSumOfDivisors = 0;
    for (int i = 1; i <= evaluate / 2; i++) {
      if (evaluate % i == 0) runningSumOfDivisors += i;
    }
    return runningSumOfDivisors > evaluate;
  }
}
