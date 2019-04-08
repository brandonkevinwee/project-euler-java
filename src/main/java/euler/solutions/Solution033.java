package euler.solutions;

import java.util.HashSet;

// If the product of the digit canceling four fractions is given in its lowest common terms, find
// the value of the denominator.
public class Solution033 {

  public static String getAnswer() {
    double originalQuotient = 0;
    double reducedQuotient = 0;
    int newFractionNumerator = 1;
    int newFractionDenominator = 1;
    for (int numerator = 10; numerator <= 99; numerator++) {
      for (int denominator = numerator + 1; denominator <= 99; denominator++) {
        if (numerator % 10 == 0 || denominator % 10 == 0) continue;
        if (numerator % 11 == 0 || denominator % 11 == 0) continue;

        String numberInString = numerator + "" + denominator;
        if (numberInString.length() == numberInString.chars().distinct().count()) continue;

        originalQuotient = (double) numerator / denominator;
        HashSet<Character> setToFindDuplicate = new HashSet<Character>();
        char duplicateCharacter = ' ';
        for (char digitCharacter : numberInString.toCharArray()) {
          if (!setToFindDuplicate.add(digitCharacter)) duplicateCharacter = digitCharacter;
        }

        String duplicateString = Character.toString(duplicateCharacter);
        String numeratorString = Integer.toString(numerator);
        String denominatorString = Integer.toString(denominator);
        int newNumerator = Integer.valueOf(numeratorString.replace(duplicateString, ""));
        int newDenominator = Integer.valueOf(denominatorString.replace(duplicateString, ""));
        reducedQuotient = (double) newNumerator / newDenominator;
        if (originalQuotient == reducedQuotient) {
          newFractionNumerator *= newNumerator;
          newFractionDenominator *= newDenominator;
        }
      }
    }
    return Integer.toString(
        newFractionDenominator
            / findGreatestCommonDivisor(newFractionNumerator, newFractionDenominator));
  }

  private static int findGreatestCommonDivisor(int a, int b) {
    int x = a;
    int y = b;
    while (x % y != 0) {
      int temporary = x;
      x = y;
      y = temporary % x;
    }
    return y;
  }
}
