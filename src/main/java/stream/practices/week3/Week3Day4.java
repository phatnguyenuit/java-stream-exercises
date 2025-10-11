package stream.practices.week3;

import java.util.List;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 12:10
 * @project java-stream-exercises
 */
public class Week3Day4 {
  /*
  Day 4 – Reduce with multiplication
	• Task: Multiply integers with reduce().
	• Input: [2, 3, 4]
	• Output: 24
	• Input with zero: [2, 0, 4] → 0
	• Empty list case: [] → 1 (if identity chosen) or Optional.empty.
   */

  // Use reduce() to multiply list of integers
  public static int multiply(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }

    return numbers.stream()
        .mapToInt(Integer::intValue)
        .reduce(1, (a, b) -> a * b);
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 0, 5);

    System.out.println(multiply(numbers));

  }
}
