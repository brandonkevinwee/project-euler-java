package euler.solutions;

// What is the largest prime factor of the number 600851475143?
public class Solution003 {

  public static String getAnswer() {
    long number = 600851475143L;
    long largestPrimeFactor = 0;
    for (long i = 3; i * i < number; i += 2) {
      if (number % i == 0 && isPrime(i)) {
        largestPrimeFactor = i;
      }
    }
    return Long.toString(largestPrimeFactor);
  }

  private static boolean isPrime(long evaluate) {
    for (long i = 3; i * i < evaluate; i += 2) {
      if (evaluate % i == 0) return false;
    }
    return true;
  }
}
