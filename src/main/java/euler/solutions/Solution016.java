package euler.solutions;

// What is the sum of the digits of the number 2^1000?
import java.math.BigInteger;

public class Solution016 {

  public static String getAnswer() {
    BigInteger base = new BigInteger("2");
    BigInteger largeNumber = base.pow(1000);
    BigInteger runningSum = BigInteger.ZERO;
    while (true) {
      runningSum = runningSum.add(largeNumber.mod(BigInteger.TEN));
      largeNumber = largeNumber.divide(BigInteger.TEN);
      if (largeNumber.compareTo(BigInteger.ZERO) == 0) break;
    }
    return runningSum.toString();
  }
}
