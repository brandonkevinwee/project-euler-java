package euler.solutions;

// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
public class Solution030 {

  public static String getAnswer() {
    int runningSum = 0;
    for (int i = 2; i <= 400000; i++) {
      if (i == sumOfFifthPowers(i)) runningSum += i;
    }
    return Integer.toString(runningSum);
  }

  private static int sumOfFifthPowers(int evaluate) {
    int number = evaluate;
    int digit = 0;
    int sumOfFifthPower = 0;
    while (number > 0) {
      digit = number % 10;
      number /= 10;
      sumOfFifthPower += Math.pow(digit, 5);
    }
    return sumOfFifthPower;
  }
}
