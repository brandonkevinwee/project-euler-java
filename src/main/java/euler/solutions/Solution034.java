package euler.solutions;

// Find the sum of all numbers which are equal to the sum of the factorial of their digits.
public class Solution034 {

  public static String getAnswer() {
    int sumOfCuriousNumbers = 0;
    for (int i = 10; i <= 2540160; i++) {
      int number = i;
      int runningSum = 0;
      while (number != 0) {
        runningSum += getFactorial(number % 10);
        number /= 10;
      }
      if (i == runningSum) sumOfCuriousNumbers += i;
    }
    return Integer.toString(sumOfCuriousNumbers);
  }

  private static int getFactorial(int evaluate) {
    int number = evaluate;
    int factorial = 1;
    while (number != 0) {
      factorial *= number;
      number--;
    }
    return factorial;
  }
}
