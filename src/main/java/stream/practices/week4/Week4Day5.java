package stream.practices.week4;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 22:52
 * @project java-stream-exercises
 */
public class Week4Day5 {

  /*
  Day 5 – Limit + skip
	• Task: Use limit() and skip() to control how many elements appear in the stream.
	• Input: [10, 20, 30, 40, 50, 60]
	• Expected Output (limit 3): [10, 20, 30]
	• Expected Output (skip 2): [30, 40, 50, 60]
	• Expected Output (skip 2, limit 3): [30, 40, 50]
   */

  public static <T> List<T> getListElements(List<T> list, int skip, int limit) {
    Stream<T> stream =  Optional.ofNullable(list)
        .orElse(List.of()).stream();

    if (skip > 0) {
      stream = stream.skip(skip);
    }

    if (limit > 0) {
      stream = stream.limit(limit);
    }

    return stream.toList();
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60);
    System.out.println(getListElements(numbers, 0, 3));
    System.out.println(getListElements(numbers, 2, 0));
    System.out.println(getListElements(numbers, 2, 3));
  }
}
