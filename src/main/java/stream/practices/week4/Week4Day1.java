package stream.practices.week4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 17:45
 * @project java-stream-exercises
 */
public class Week4Day1 {

  /*
    Day 1 – flatMap with list of lists
    • Task: Flatten a list of lists into a single stream of elements.
    • Input: [[1, 2], [3, 4], [5]]
    • Expected Output: [1, 2, 3, 4, 5]
  */
  public static <T> List<T> flatten(List<List<T>> lists) {
    // handle lists null, and contains null as well
    return Optional.ofNullable(lists)
        .orElse(List.of())
        .stream()
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .toList();
  }

  public static void main(String[] args) {
    List<List<Integer>> numbers = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(4, 5),
        List.of(6)
    );

    System.out.println(flatten(numbers));
  }

}
