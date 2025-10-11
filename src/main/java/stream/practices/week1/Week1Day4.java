package stream.practices.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week1Day4 {
  /*
  Day 4 – Practice forEach → print elements with custom formatting
	• Input:
    [10, 20, 30]
	• Expected Output:
    Number: 10
    Number: 20
    Number: 30
   */

  // forEach with custom format
  public static void callForEachWithConsumer(List<Integer> numbers, Consumer<Integer> consumer) {
    numbers.stream().forEach(consumer);
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    callForEachWithConsumer(numbers, e -> System.out.print(e + " -> "));
  }
}
