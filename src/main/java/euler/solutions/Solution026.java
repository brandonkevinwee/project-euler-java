package euler.solutions;

import java.util.ArrayList;

// Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal
// fraction part.
public class Solution026 {

  public static String getAnswer() {
    int highestPatternLength = 0;
    int denominatorOfHighestPatternLength = 0;
    int patternLength = 0;
    for (int i = 2; i <= 1000; i++) {
      patternLength = getPatternLength(i);
      if (patternLength > highestPatternLength) {
        highestPatternLength = patternLength;
        denominatorOfHighestPatternLength = i;
      }
    }
    return Integer.toString(denominatorOfHighestPatternLength);
  }

  private static int getPatternLength(int evaluate) {
    ArrayList<Integer> remainderList = new ArrayList<Integer>();
    int remainder = 1 % evaluate;
    remainderList.add(remainder);
    int length = 1;
    while (true) {
      remainder = remainder * 10;
      remainder = remainder % evaluate;
      if (remainder == 0) return 0;
      if (remainderList.contains(remainder)) return length - remainderList.indexOf(remainder);
      length++;
      remainderList.add(remainder);
    }
  }
}
