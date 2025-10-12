package stream.practices.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 16:48
 * @project java-stream-exercises
 */
public class Week4Day5Test {

  final static List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60);

  @Test
  @DisplayName("should return a list of elements with skip")
  void testSkip() {
    assertEquals(List.of(40, 50, 60), Week4Day5.getListElements(numbers, 3, 0));
  }

  @Test
  @DisplayName("should return a list of elements with limit")
  void testLimit() {
    assertEquals(List.of(10, 20), Week4Day5.getListElements(numbers, 0, 2));
  }

  @Test
  @DisplayName("should return a list of elements with both skip and limit")
  void testSkipAndLimit() {
    assertEquals(List.of(20, 30), Week4Day5.getListElements(numbers, 1, 2));
  }

  @Test
  @DisplayName("should return an empty list if passing null as a list")
  void testNullList() {
    assertEquals(List.of(), Week4Day5.getListElements(null, 1, 2));
  }

  @Test
  @DisplayName("should return the original list of passing zero or negative numbers for skip and limit")
  void testZeroOrNegativeNumbers() {
    assertEquals(numbers, Week4Day5.getListElements(numbers, -1, -1));
  }
}
