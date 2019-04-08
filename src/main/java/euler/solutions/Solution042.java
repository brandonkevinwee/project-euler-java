package euler.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// How many words in the file are triangle words?
public class Solution042 {

  public static String getAnswer() throws Exception {
    File nameFile = new File("src/main/resources/euler/solutions/Problem042.txt");
    BufferedReader reader = new BufferedReader(new FileReader(nameFile));
    String nameString = reader.readLine();
    reader.close();
    nameString = nameString.replace("\"", "");
    String[] nameStrings = nameString.split(",");
    List<Integer> scoreList = new ArrayList<Integer>();
    for (String name : nameStrings) {
      scoreList.add(getScore(name));
    }

    int maxScore = scoreList.stream().mapToInt(a -> a).max().getAsInt();
    List<Integer> triangleNumbers = new ArrayList<Integer>();
    int i = 1;
    int triangleNumber = 0;
    while (triangleNumber <= maxScore) {
      triangleNumber = (int) i * (i + 1) / 2;
      triangleNumbers.add(triangleNumber);
      i++;
    }

    scoreList =
        scoreList.stream().filter(j -> triangleNumbers.contains(j)).collect(Collectors.toList());
    return String.valueOf(scoreList.size());
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
