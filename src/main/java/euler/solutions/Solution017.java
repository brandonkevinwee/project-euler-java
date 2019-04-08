package euler.solutions;

// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many
// letters would be used?
public class Solution017 {

  public static String getAnswer() {
    int runningSum = 0;
    for (int i = 1; i <= 1000; i++) {
      runningSum += returnNumberInWords(i).length();
    }
    return Integer.toString(runningSum);
  }

  private static String returnNumberInWords(int evaluate) {
    String[] oneToTwentyOnes = {
      "",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
      "ten",
      "eleven",
      "twelve",
      "thirteen",
      "fourteen",
      "fifteen",
      "sixteen",
      "seventeen",
      "eighteen",
      "nineteen",
      "twenty"
    };
    String[] thirtyToNinetyTens = {
      "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    int originalEvaluate = evaluate;
    int[] digits = new int[4];
    digits[3] = (int) (evaluate / 1000);
    evaluate %= 1000;
    digits[2] = (int) (evaluate / 100);
    evaluate %= 100;
    digits[1] = (int) (evaluate / 10);
    evaluate %= 10;
    digits[0] = (int) (evaluate);

    if (originalEvaluate <= 20) {
      return oneToTwentyOnes[originalEvaluate];
    } else if (originalEvaluate < 100) {
      String tens = thirtyToNinetyTens[digits[1]];
      String ones = oneToTwentyOnes[digits[0]];
      return tens + ones;
    } else if (originalEvaluate < 1000) {
      String hundreds = oneToTwentyOnes[digits[2]] + "hundred";
      String tens = "";
      String ones = "";
      if (digits[1] != 0 || digits[0] != 0) tens += "and";
      if (digits[1] >= 2) {
        tens += thirtyToNinetyTens[digits[1]];
        ones += oneToTwentyOnes[digits[0]];
      } else {
        ones = oneToTwentyOnes[digits[1] * 10 + digits[0]];
      }
      return hundreds + tens + ones;
    } else {
      return "onethousand";
    }
  }
}
