package euler.solutions;

// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
public class Solution005 {

  public static String getAnswer() {
    int number = 1;
    while (!isDivisible(number)) {
      number++;
    }
    return Integer.toString(number);
  }

  private static boolean isDivisible(int evaluate) {
    for (int i = 1; i <= 20; i++) {
      if (evaluate % i != 0) return false;
    }
    return true;
  }
}
