package euler.solutions;

// Find the sum of all the primes below two million.
public class Solution010 {

  public static String getAnswer() {
    long runningSum = 0;
    for (int i = 1; i < 2000000; i++) {
      if (isPrime(i)) runningSum += i;
    }
    return Long.toString(runningSum);
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
