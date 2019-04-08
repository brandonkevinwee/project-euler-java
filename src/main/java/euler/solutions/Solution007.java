package euler.solutions;

// What is the 10001st prime number?
public class Solution007 {

  public static String getAnswer() {
    long number = 0;
    int primeCount = 0;
    while (primeCount != 10001) {
      number++;
      if (isPrime(number)) primeCount++;
    }
    return Long.toString(number);
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
