package euler.solutions;

import java.util.Arrays;
import java.util.HashSet;

// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1
// through 9 pandigital.
public class Solution032 {

  public static String getAnswer() {
    HashSet<Integer> setOfProducts = new HashSet<Integer>();
    for (int i = 1; i <= 10000; i++) {
      for (int j = 1; j <= 10000; j++) {
        if (isPandigital(i, j)) setOfProducts.add(i * j);
      }
    }
    return Integer.toString(setOfProducts.stream().mapToInt(Integer::valueOf).sum());
  }

  private static boolean isPandigital(int i, int j) {
    int product = i * j;
    String numberString = Integer.toString(product) + Integer.toString(i) + Integer.toString(j);
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
