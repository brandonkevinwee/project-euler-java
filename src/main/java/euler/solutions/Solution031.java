package euler.solutions;

// How many different ways can £2 be made using any number of coins (1p, 2p, 5p, 10p, 20p, 50p, £1
// [100p] and £2[200p])?
public class Solution031 {

  public static String getAnswer() {
    int numberOfWays = 0;
    int total = 0;
    for (int one = 0; one <= 200; one += 1) {
      for (int two = 0; two <= 200; two += 2) {
        for (int five = 0; five <= 200; five += 5) {
          for (int ten = 0; ten <= 200; ten += 10) {
            for (int twenty = 0; twenty <= 200; twenty += 20) {
              for (int fifty = 0; fifty <= 200; fifty += 50) {
                for (int oneHundred = 0; oneHundred <= 200; oneHundred += 100) {
                  for (int twoHundred = 0; twoHundred <= 200; twoHundred += 200) {
                    total = one + two + five + ten + twenty + fifty + oneHundred + twoHundred;
                    if (total == 200) numberOfWays++;
                  }
                }
              }
            }
          }
        }
      }
    }
    return Integer.toString(numberOfWays);
  }
}
