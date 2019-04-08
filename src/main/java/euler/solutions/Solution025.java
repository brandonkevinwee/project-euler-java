package euler.solutions;

import java.math.BigInteger;

// What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
public class Solution025 {

  public static String getAnswer() {
    BigInteger nMinusOne = BigInteger.ONE;
    BigInteger n = BigInteger.ONE;
    BigInteger placeHolder = BigInteger.ZERO;
    int nLength = 0;
    int index = 2;
    while (nLength != 1000) {
      placeHolder = n.add(nMinusOne);
      nMinusOne = n;
      n = placeHolder;
      nLength = n.toString().length();
      index++;
    }
    return Integer.toString(index);
  }
}
