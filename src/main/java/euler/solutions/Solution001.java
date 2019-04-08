package euler.solutions;

// Find the sum of all the multiples of 3 or 5 below 1000
public class Solution001 {

  public static String getAnswer() {
    int runningSum = 0;
    for (int i = 1; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) runningSum += i;
    }
    return Integer.toString(runningSum);
  }
}
