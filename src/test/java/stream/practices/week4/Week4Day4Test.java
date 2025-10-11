package stream.practices.week4;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 22:47
 * @project java-stream-exercises
 */
public class Week4Day4Test {

  @Test
  @DisplayName("should return list of unique numbers")
  void testUniqueNumbers() {
    List<Integer> numbers = List.of(1, 2, 3, 1, 2, 4);

    assertEquals(List.of(1, 2, 3, 4), Week4Day4.removeDuplicates(numbers));
  }

  @Test
  @DisplayName("should return list of unique strings")
  void testUniqueStrings() {
    List<String> fruits = List.of("Apple", "Pearl", "Apple");

    assertEquals(List.of("Apple", "Pearl"), Week4Day4.removeDuplicates(fruits));
  }

  @Test
  @DisplayName("should return empty list for null")
  void testNullList() {
    assertEquals(List.of(), Week4Day4.removeDuplicates(null));
  }
}
