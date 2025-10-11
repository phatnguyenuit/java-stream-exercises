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
public class Week1Day2 {

  /*
  Day 2 – Practice map with integers → square each element
	• Input:
    [1, 2, 3, 4, 5]
	• Expected Output:
    [1, 4, 9, 16, 25]

   */

  // Map integers to square numbers with Stream
  public static List<Integer> toSquare(List<Integer> numbers) {
    return numbers.stream().map(x -> x * x).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(toSquare(numbers));
  }
}
