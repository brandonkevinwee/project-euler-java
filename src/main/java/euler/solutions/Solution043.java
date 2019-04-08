package euler.solutions;

// Find the sum of all 0 to 9 pandigital numbers with specific sub-string divisibility properties
public class Solution043 {

  public static String getAnswer() {
    int[] pandigitalDigitsArray = {1, 0, 2, 3, 4, 5, 6, 7, 8, 9};
    long runningSum = 0;
    do {
      if (satisfiesDivisibilityProperty(pandigitalDigitsArray)) {
        long pandigitalNumber = 0;
        for (int i = 0; i <= 9; i++) {
          pandigitalNumber = pandigitalNumber * 10 + pandigitalDigitsArray[i];
        }
        runningSum += pandigitalNumber;
      }
    } while (getNextPermutation(pandigitalDigitsArray));

    return String.valueOf(runningSum);
  }

  private static boolean satisfiesDivisibilityProperty(int[] evaluate) {
    int[] divisor = {2, 3, 5, 7, 11, 13, 17};
    for (int i = 1; i <= 7; i++) {
      int dividend = evaluate[i] * 100 + evaluate[i + 1] * 10 + evaluate[i + 2];
      if (dividend % divisor[i - 1] != 0) return false;
    }
    return true;
  }

  public static boolean getNextPermutation(int[] evaluate) {
    // Set pivot to the head of the suffix, pivot-1 serving as the position of the true pivot
    int pivot = evaluate.length - 1;
    while (pivot > 0 && evaluate[pivot - 1] >= evaluate[pivot]) {
      pivot--;
    }
    // Return the same array if this is the highest permutation
    if (pivot <= 0) {
      return false;
    }
    // Set successor as the right most element that exceeds the pivot
    int successor = evaluate.length - 1;
    while (evaluate[successor] <= evaluate[pivot - 1]) {
      successor--;
    }
    // swap the successor and the pivot
    int placeHolder = evaluate[pivot - 1];
    evaluate[pivot - 1] = evaluate[successor];
    evaluate[successor] = placeHolder;
    // reverse the suffix
    successor = evaluate.length - 1;
    while (pivot < successor) {
      placeHolder = evaluate[pivot];
      evaluate[pivot] = evaluate[successor];
      evaluate[successor] = placeHolder;
      pivot++;
      successor--;
    }
    return true;
  }
}
