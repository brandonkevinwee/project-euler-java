package euler.solutions;

// There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
public class Solution009 {

  public static String getAnswer() {
    int product = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 1; j < 1000; j++) {
        for (int k = 1; k < 1000; k++) {
          if (i + j + k == 1000 && i * i + j * j == k * k) {
            product = i * j * k;
          }
        }
      }
    }
    return Integer.toString(product);
  }
}
