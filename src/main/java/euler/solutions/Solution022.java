package euler.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

// What is the total of all the name scores in the file?
public class Solution022 {

  public static String getAnswer() throws Exception {
    File nameFile = new File("src/main/resources/euler/solutions/Problem022.txt");
    BufferedReader reader = new BufferedReader(new FileReader(nameFile));
    String nameString = reader.readLine();
    reader.close();
    nameString = nameString.replace("\"", "");
    String[] nameStrings = nameString.split(",");
    Arrays.parallelSort(nameStrings);

    int runningScore = 0;
    for (int i = 1; i < nameStrings.length + 1; i++) {
      runningScore += getScore(nameStrings[i - 1]) * i;
    }
    return Long.toString(runningScore);
  }

  private static int getScore(String evaluate) {
    char[] letterArray = evaluate.toCharArray();
    int runningScore = 0;
    for (char letter : letterArray) {
      runningScore += (int) letter - 64;
    }
    return runningScore;
  }
}
