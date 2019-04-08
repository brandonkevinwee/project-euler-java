package euler.solutions;

import java.util.ArrayList;
import java.util.List;

// Find the value of the expression d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 for
// Champernowne's constant
public class Solution040 {

  public static String getAnswer() {
    int number = 1;
    List<Integer> digitArray = new ArrayList<Integer>();
    do {
      String reversedDigits = String.valueOf(number);
      do {
        digitArray.add(Integer.valueOf(reversedDigits.substring(0, 1)));
        reversedDigits = reversedDigits.substring(1);
      } while (reversedDigits.length() > 0);
      number++;
    } while (digitArray.size() < 1000000);
    return Integer.toString(
        digitArray.get(0)
            * digitArray.get(9)
            * digitArray.get(99)
            * digitArray.get(999)
            * digitArray.get(9999)
            * digitArray.get(99999)
            * digitArray.get(999999));
  }
}
