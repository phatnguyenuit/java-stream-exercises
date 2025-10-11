package stream.practices.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week2Day1 {
  /*
  Day 1 – Collect a stream into a List
	• Input:
    [1, 2, 3, 4]
	• Expected Output:
    List → [1, 2, 3, 4]
   */

  // Using stream.collect(Collectors.toList())
  public static List<Integer> transformNumbers(List<Integer> numbers) {
    return numbers.stream().map(x -> x * (x + 1)).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(transformNumbers(numbers));
  }
}
