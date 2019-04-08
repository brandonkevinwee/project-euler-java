package euler.solutions;

// Find the largest palindrome made from the product of two 3-digit numbers.
public class Solution004 {

  public static String getAnswer() {
    int largestPalindrome = 0;
    int product = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 1; j < 1000; j++) {
        product = i * j;
        if (isPalindrome(product) && product > largestPalindrome) largestPalindrome = product;
      }
    }
    return Integer.toString(largestPalindrome);
  }

  private static boolean isPalindrome(int evaluate) {
    StringBuilder evaluateString = new StringBuilder(Integer.toString(evaluate));
    StringBuilder evaluateStringReverse = new StringBuilder(Integer.toString(evaluate));
    evaluateStringReverse.reverse();
    if (evaluateString.toString().equals(evaluateStringReverse.toString())) return true;
    return false;
  }
}
