package euler.solutions;

// Which starting number, under one million, produces the longest Collatz Sequence chain?
public class Solution014 {

  public static String getAnswer() {
    long longestSequence = 0;
    long collatzSequenceLength = 0;
    long collatzNumber = 0;
    for (long i = 1; i != 1000000; i++) {
      collatzSequenceLength = getCollatzSequenceLength(i);
      if (collatzSequenceLength > longestSequence) {
        longestSequence = collatzSequenceLength;
        collatzNumber = i;
      }
    }
    return Long.toString(collatzNumber);
  }

  private static long getCollatzSequenceLength(long evaluate) {
    long collatzLength = 1;
    long collatzNumber = evaluate;
    while (true) {
      if (collatzNumber == 1) break;
      else if (collatzNumber % 2 == 0) collatzNumber /= 2;
      else collatzNumber = collatzNumber * 3 + 1;
      collatzLength++;
    }
    return collatzLength;
  }
}
