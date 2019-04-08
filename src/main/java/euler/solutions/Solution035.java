package euler.solutions;

// How many circular primes are there below one million?
public class Solution035 {

  public static String getAnswer() {
    int circularPrimeCount = 0;
    for (int i = 1; i <= 1000000; i++) {
      int number = i;
      boolean allPrime = false;
      if (isPrime(number)) {
        allPrime = true;
        String numberString = String.valueOf(number);
        for (int j = 0; j < numberString.length() - 1; j++) {
          numberString = numberString.substring(1) + numberString.substring(0, 1);
          number = Integer.valueOf(numberString);
          if (!isPrime(number)) {
            allPrime = false;
            break;
          }
        }
      }
      if (allPrime) circularPrimeCount++;
    }
    return Integer.toString(circularPrimeCount);
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
