package stream.practices.week4;

import java.util.List;
import java.util.Optional;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 22:44
 * @project java-stream-exercises
 */
public class Week4Day4 {

  /*
  Day 4 – Distinct elements
	• Task: Remove duplicates from a stream.
	• Input: [1, 2, 2, 3, 4, 4, 5]
	• Expected Output: [1, 2, 3, 4, 5]
	• Bonus with strings:
		○ Input: ["apple", "banana", "apple", "pear"]
		○ Expected Output: ["apple", "banana", "pear"]
   */

  public static <T> List<T> removeDuplicates(List<T> list) {
    return Optional.ofNullable(list).orElse(List.of()).stream().distinct().toList();
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 1, 2, 4);
    List<String> fruits = List.of("Apple", "Lemon", "Guava", "Apple", "Pearl");

    System.out.println(removeDuplicates(numbers));
    System.out.println(removeDuplicates(fruits));
  }
}
