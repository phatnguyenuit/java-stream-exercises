package stream.practices.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week1Day3 {
  /*
  Day 3 – Practice filter → keep only even numbers
	• Input:
    [1, 2, 3, 4, 5, 6]
	• Expected Output:
    [2, 4, 6]
   */

  // Filter even numbers with Stream
  public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
    return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(filterEvenNumbers(numbers));
  }
}
