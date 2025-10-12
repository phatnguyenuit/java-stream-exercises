package stream.practices.week5;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 16:59
 * @project java-stream-exercises
 */
public class Week5Day1 {
  /*
  Day 1 – Group strings by length
	• Task: Use Collectors.groupingBy() to group strings by their length.
	• Input: ["one", "two", "three", "four", "six"]
	• Expected Output:
    {
      3 = [one, two, six],
      4 = [four],
      5 = [three]
    }
   */

  public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
    return Optional.ofNullable(strings)
        .orElse(List.of())
        .stream()
        .collect(Collectors.groupingBy(String::length));
  }

  public static void main(String[] args) {
    List<String> strings = List.of("one", "two", "three", "four", "five", "six");

    System.out.println(groupStringsByLength(strings));
  }
}
