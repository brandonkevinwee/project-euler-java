package euler.solutions;

// Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
public class Solution036 {

  public static String getAnswer() {
    int sumOfPalindromesBaseTenBaseTwo = 0;
    for (int i = 1; i <= 1000000; i++) {
      String baseTwoString = Integer.toBinaryString(i);
      if (isPalindrome(baseTwoString) && isPalindrome(Integer.toString(i)))
        sumOfPalindromesBaseTenBaseTwo += i;
    }
    return Integer.toString(sumOfPalindromesBaseTenBaseTwo);
  }

  private static boolean isPalindrome(String evaluate) {
    StringBuilder evaluateString = new StringBuilder(evaluate);
    StringBuilder evaluateStringReverse = new StringBuilder(evaluate);
    evaluateStringReverse.reverse();
    if (evaluateString.toString().equals(evaluateStringReverse.toString())) return true;
    return false;
  }
}
