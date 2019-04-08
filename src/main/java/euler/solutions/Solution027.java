package euler.solutions;

/*Find the product of the coefficients, a and b, for the quadratic expression that
produces the maximum number of primes for consecutive values of n, starting with n=0.*/
public class Solution027 {

  public static String getAnswer() {
    int highestCoefficientProduct = 0;
    for (int a = -1000; a <= 1000; a++) {
      for (int b = -1000; b <= 1000; b++) {
        int consecutivePrimes = 0;
        int n = 0;
        while (isPrime(absoluteQuadraticSum(a, b, n))) {
          consecutivePrimes++;
          n++;
        }
        int highestConsecutivePrimes = 0;
        if (consecutivePrimes > highestConsecutivePrimes) {
          highestConsecutivePrimes = consecutivePrimes;
          highestCoefficientProduct = a * b;
        }
      }
    }
    return Integer.toString(highestCoefficientProduct);
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

  private static int absoluteQuadraticSum(int a, int b, int n) {
    return Math.abs(n * n + a * n + b);
  }
}
