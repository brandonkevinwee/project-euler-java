package euler.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// For which value of p <= 1000, is the number of solutions maximized, where p is the perimeter of a
// right angle triangle with integral length sides?
public class Solution039 {

  public static String getAnswer() {
    int valueOfPerimeter = 0;
    int greatestNumberOfSolutions = 0;
    for (int p = 2; p <= 1000; p++) {
      int currentNumberOfSolutions = numberOfSolutions(p);
      if (currentNumberOfSolutions > greatestNumberOfSolutions) {
        greatestNumberOfSolutions = currentNumberOfSolutions;
        valueOfPerimeter = p;
      }
    }
    return Integer.toString(valueOfPerimeter);
  }

  private static int numberOfSolutions(int perimeter) {
    HashSet<List<Integer>> sidesSet = new HashSet<List<Integer>>();
    for (int a = perimeter; a > 0; a--) {
      for (int b = perimeter - a; b > 0; b--) {
        int c = perimeter - a - b;
        int d = (int) Math.ceil((perimeter - a) / 2.0);
        if (b < d) break;

        int[] sideArray = {a, b, c};
        Arrays.sort(sideArray);
        List<Integer> sideList = Arrays.stream(sideArray).boxed().collect(Collectors.toList());
        sidesSet.add(sideList);
      }
    }

    int solutionCounter = 0;
    for (List<Integer> sides : sidesSet) {
      int hypotenuseSquared = sides.get(2) * sides.get(2);
      int longerSideSquared = sides.get(1) * sides.get(1);
      int shorterSideSquared = sides.get(0) * sides.get(0);
      if (hypotenuseSquared == longerSideSquared + shorterSideSquared) solutionCounter++;
    }
    return solutionCounter;
  }
}
