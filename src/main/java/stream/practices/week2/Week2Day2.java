package stream.practices.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week2Day2 {
  /*
  Day 2 – Collect into a Set
	• Input:
    [1, 2, 2, 3, 3, 4]
	• Expected Output:
    Set → [1, 2, 3, 4]   // no duplicates
   */

  // Using stream.collect(Collectors.toSet())
  public static Set<Integer> getUniqueNumbers(List<Integer> numbers) {
    return numbers.stream().collect(Collectors.toSet());
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 5, 4, 5));
    System.out.println(getUniqueNumbers(numbers));
  }
}
