package stream.practices.week2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week2Day3 {
  /*
  Day 3 – Collect into a Map
	• Task: Map each string to its length.
	• Input:
    ["apple", "banana", "cherry"]
	• Expected Output:
    {apple=5, banana=6, cherry=6}
   */

  // Using stream.collect(Collectors.toMap())
  public static Map<String, Integer> countWordFrequency(String str) {
    return Arrays.stream(str.split(" ")).collect(Collectors.toMap(
        word -> word,
        word -> 1,
        // Accumulate all frequency of word
        (a, b) -> a + b
    ));
  }

  public static void main(String[] args) {
    System.out.println(countWordFrequency("hello world I am Fast and I am here to learn Java"));
  }
}
