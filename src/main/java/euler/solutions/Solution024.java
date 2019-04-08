package euler.solutions;

import java.util.Arrays;

// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
public class Solution024 {

  public static String getAnswer() {
    int[] permutation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i = 1; i < 1000000; i++) {
      getNextPermutation(permutation);
    }
    return Arrays.toString(permutation);
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
