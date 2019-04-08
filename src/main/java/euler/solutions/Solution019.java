package euler.solutions;

import java.util.Calendar;

// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31
// Dec 2000)?
public class Solution019 {

  public static String getAnswer() {
    Calendar startDate = Calendar.getInstance();
    startDate.set(1901, Calendar.JANUARY, 1);
    Calendar endDate = Calendar.getInstance();
    endDate.set(2000, Calendar.DECEMBER, 31);
    int sundayCounter = 0;
    while (startDate.before(endDate)) {
      if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        sundayCounter++;
      }
      startDate.add(Calendar.MONTH, 1);
    }
    return Integer.toString(sundayCounter);
  }
}
