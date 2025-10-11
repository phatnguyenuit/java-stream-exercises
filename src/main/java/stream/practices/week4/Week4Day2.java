package stream.practices.week4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 21:31
 * @project java-stream-exercises
 */
public class Week4Day2 {

  /*
  Day 2 – flatMap with sentences → words
	• Task: Split sentences into words and flatten them into one stream.
	• Input: ["Java is fun", "Streams are powerful"]
	• Expected Output: ["Java", "is", "fun", "Streams", "are", "powerful"]
  */
  public static List<String> flattenSentences(List<String> sentences) {
    return Optional.ofNullable(sentences)
        .orElse(List.of())
        .stream()
        .map(sentence -> sentence.trim().split("\\s+"))
        .flatMap(Arrays::stream)
        .toList();
  }

  public static void main(String[] args) {
    List<String> strings = List.of("   Java is    fun", "Stream    is   powerful");

    System.out.println(flattenSentences(strings));
    System.out.println(flattenSentences(null));
  }
}
