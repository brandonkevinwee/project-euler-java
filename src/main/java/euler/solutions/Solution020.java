package euler.solutions;

import java.math.BigInteger;

// Find the sum of the digits in the number 100!
public class Solution020 {

  public static String getAnswer() {
    BigInteger largeFactorial = BigInteger.ONE;
    for (long i = 1; i <= 100; i++) {
      largeFactorial = largeFactorial.multiply(BigInteger.valueOf(i));
    }
    BigInteger runningSum = BigInteger.ZERO;
    while (true) {
      runningSum = runningSum.add(largeFactorial.mod(BigInteger.TEN));
      largeFactorial = largeFactorial.divide(BigInteger.TEN);
      if (largeFactorial.compareTo(BigInteger.ZERO) == 0) break;
    }
    return runningSum.toString();
  }
}
