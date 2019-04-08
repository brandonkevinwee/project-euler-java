package euler.solutions;

// By considering the terms in the Fibonacci sequence whose values do not exceed four million, find
// the sum of the even-valued terms.
public class Solution002 {

  public static String getAnswer() {
    int oldValue = 1;
    int newValue = 2;
    int nextValue = 0;
    int runningSum = 2;
    while (nextValue < 4000000) {
      nextValue = newValue + oldValue;
      oldValue = newValue;
      newValue = nextValue;
      if (nextValue % 2 == 0) runningSum += nextValue;
    }
    return Integer.toString(runningSum);
  }
}
