package stream.practices.week5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 16:59
 * @project java-stream-exercises
 */
public class Week5Day1Test {
  final static List<String> strings = List.of("one", "two", "three", "four", "six");

  @Test
  @DisplayName("should group strings by their length")
  void testGroupStringsByLength() {
    Map<Integer, List<String>> expected = Map.of(
        3, List.of("one", "two", "six"),
        4, List.of("four"),
        5, List.of("three")
    );
    assertEquals(expected, Week5Day1.groupStringsByLength(strings));
  }

  @Test
  @DisplayName("should return an empty map if the input list is empty")
  void testEmptyList() {
    Map<Integer, List<String>> expected = Map.of();
    assertEquals(expected, Week5Day1.groupStringsByLength(List.of()));
  }

  @Test
  @DisplayName("should return an empty map if the input list is null")
  void testNullList() {
    Map<Integer, List<String>> expected = Map.of();
    assertEquals(expected, Week5Day1.groupStringsByLength(null));
  }

}
