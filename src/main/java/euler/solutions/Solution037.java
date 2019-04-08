package euler.solutions;

// Find the sum of the only eleven primes that are both truncatable from left to right and right to
// left.
public class Solution037 {

  public static String getAnswer() {
    int primeCount = 0;
    long primeSum = 0;
    long i = 9;
    while (primeCount != 11) {
      i++;
      if (!isPrime(i)) continue;

      long modifyLeftDigits = i;
      boolean allPrimeFromLeft = false;
      long modifyRightDigits = i;
      boolean allPrimeFromRight = false;
      while (truncateLeftDigit(modifyLeftDigits) != 0) {
        modifyLeftDigits = truncateLeftDigit(modifyLeftDigits);
        if (isPrime(modifyLeftDigits)) {
          allPrimeFromLeft = true;
        } else {
          allPrimeFromLeft = false;
          break;
        }
      }

      if (allPrimeFromLeft == true) {
        while (truncateRightDigit(modifyRightDigits) != 0) {
          modifyRightDigits = truncateRightDigit(modifyRightDigits);
          if (isPrime(modifyRightDigits)) {
            allPrimeFromRight = true;
          } else {
            allPrimeFromRight = false;
            break;
          }
        }
      }
      if (allPrimeFromRight == true) {
        primeCount++;
        primeSum += i;
      }
    }
    return Long.toString(primeSum);
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

  private static long truncateLeftDigit(long evaluate) {
    return evaluate % (long) Math.pow(10, (long) Math.log10(evaluate));
  }

  private static long truncateRightDigit(long evaluate) {
    return (long) evaluate / 10;
  }
}
