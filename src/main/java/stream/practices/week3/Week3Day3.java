package stream.practices.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 11:32
 * @project java-stream-exercises
 */
public class Week3Day3 {
  /*
  Day 3 – Reduce a list of integers to sum
	• Task: Sum integers with reduce().
	• Input: [1, 2, 3, 4, 5]
	• Output: 15
	• Empty list case: [] → 0 or Optional.empty (depending on implementation).
	• Bonus: Compare with mapToInt().sum().
   */

  // Reduce a list of integers to sum
  public static int sum(List<Integer> numbers) {
    return numbers.stream().reduce(0, Integer::sum);
  }

  // This is better as we use Int stream to sum, no need boxing and boxing repeated everytime
  public static int sum2(List<Integer> numbers) {
    return numbers.stream().mapToInt(Integer::intValue).sum();
  }

  public static long getExecutionTime(Runnable runnable) {
    long startTime = System.currentTimeMillis();
    runnable.run();
    long endTime = System.currentTimeMillis();

    return (endTime - startTime);
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 1_000_000; i++) {
      numbers.add(i + 10);
    }

    long executionTime1 = getExecutionTime(() -> sum(numbers));
    System.out.println("Execution time of sum: " + executionTime1 + " milliseconds");

    long executionTime2 = getExecutionTime(() -> sum2(numbers));
    System.out.println("Execution time of sum2: " + executionTime2 + " milliseconds");
  }
}
