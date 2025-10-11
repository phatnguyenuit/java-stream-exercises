package stream.practices.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week1Day1 {
/*
  Day 1 – Create a list of integers → convert to stream → print elements
    • Input:
      [1, 2, 3, 4, 5]
    • Expected Output:
      1
      2
      3
      4
      5
 */

  // Create a list of integers → convert to stream → print elements
  public static void printStreamElements(List<Integer> numbers) {
    numbers.stream().forEach(System.out::println);
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    printStreamElements(numbers);
  }
}
