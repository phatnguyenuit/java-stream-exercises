package stream.practices.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week1Day5 {
  /*
  Day 5 – Combine map + filter
	• Task: Square each number, then keep only results greater than 10.
	• Input:
    [2, 3, 4, 5]
	• Expected Output:
    [16, 25]
   */

  // Combine filter + map
  public static List<Integer> toSquareEvenNumbers(List<Integer> numbers) {
    return numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).toList();
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(toSquareEvenNumbers(numbers));
  }

}
