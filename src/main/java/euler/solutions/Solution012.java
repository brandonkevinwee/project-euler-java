package euler.solutions;

// What is the value of the first triangle number to have over five hundred divisors?
public class Solution012 {

  public static String getAnswer() {
    long i = 1;
    long triangleNumber = 0;
    while (true) {
      triangleNumber += i;
      if (numberOfDivisor(triangleNumber) > 500) break;
      i++;
    }
    return Long.toString(triangleNumber);
  }

  private static int numberOfDivisor(long evaluate) {
    int numberOfDivisor = 1;
    for (long i = 1; i * i <= evaluate; i++) {
      if (evaluate % i == 0) numberOfDivisor++;
    }
    return numberOfDivisor * 2;
  }
}
