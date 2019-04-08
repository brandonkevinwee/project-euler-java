package euler;

import java.lang.reflect.Method;
import java.util.Scanner;

//Launcher for SolutionXXX Classes
public class SolutionLauncher {

  public static void main(String[] args) throws Exception {
    System.out.print("Provide Project Euler problem number:");
    Scanner input = new Scanner(System.in);
    int problemNumber = input.nextInt();

    String solutionClassString = "euler.solutions.Solution" + String.format("%03d", problemNumber);
    Class<?> solutionClass = Class.forName(solutionClassString);
    Method solutionMethod = solutionClass.getMethod("getAnswer");
    System.out.println(solutionMethod.invoke(solutionClass));
    input.close();
  }
}
