package stream.practices.week2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week2Day4 {
  /*
  Day 4 – Use joining() on a list of strings
	• Input:
    ["Java", "Streams", "API"]
	• Expected Output:
    "Java, Streams, API"
   */

  // Using stream.collect(Collectors.joining())
  public static String transformString(String str, int minLength) {
    return Arrays.stream(str.split(" ")).filter(s -> s.length() >= minLength)
        .collect(Collectors.joining("->"));
  }

  public static void main(String[] args) {
    System.out.println(transformString("Hi where are you today?", 2));
  }
}
