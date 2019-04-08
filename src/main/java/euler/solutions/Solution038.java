package euler.solutions;

import java.util.Arrays;

// What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated
// product of an integer with (1,2, ... , n) where n > 1?
public class Solution038 {

  public static String getAnswer() {
    int largestPandigital = 0;
    for (int i = 9000; i <= 10000; i++) {
      if (isPandigital(Integer.toString(i) + Integer.toString(i * 2))) {
        if (i > largestPandigital) largestPandigital = i;
      }
    }
    return Integer.toString(largestPandigital) + Integer.toString(largestPandigital * 2);
  }

  private static boolean isPandigital(String evaluate) {
    String numberString = evaluate;
    if (numberString.length() != 9) return false;

    char[] numberStringArray = new char[9];
    for (int k = 0; k < 9; k++) {
      numberStringArray[k] = numberString.charAt(k);
    }

    Arrays.sort(numberStringArray);
    return Arrays.equals(
        numberStringArray, new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'});
  }
}
