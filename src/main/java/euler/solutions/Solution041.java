package euler.solutions;

import java.util.Arrays;

// What is the largest n-digit pandigital prime that exists?
public class Solution041 {

  public static String getAnswer() {
    long largestPandigitalPrime = 0;
    for (long i = 1; i <= 987654321; i = i + 2) {
      if (isPandigital(String.valueOf(i)) && isPrime(i)) largestPandigitalPrime = i;
    }
    return String.valueOf(largestPandigitalPrime);
  }

  private static boolean isPandigital(String evaluate) {
    char[] digitArray = evaluate.toCharArray();
    Arrays.sort(digitArray);
    char[] comparisonArray = new char[digitArray.length];
    for (int i = 1; i <= digitArray.length; i++) {
      comparisonArray[i - 1] = (char) (i + '0');
    }
    return Arrays.equals(digitArray, comparisonArray);
  }

  private static boolean isPrime(long evaluate) {
    if (evaluate == 1) return false;
    if (evaluate == 2) return true;
    if (evaluate % 2 == 0) return false;
    for (long i = 3; i * i <= evaluate; i += 2) {
      if (evaluate % i == 0) return false;
    }
    return true;
  }
}
