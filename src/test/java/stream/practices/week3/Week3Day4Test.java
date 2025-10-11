package stream.practices.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 16:48
 * @project java-stream-exercises
 */
public class Week3Day4Test {

  // Test multiply integers with reduce
  final static List<Integer> numbers = List.of(1, 2, 3, 4, 5);
  final static List<Integer> numbersWithZero = List.of(1, 2, 3, 0, 5);
  final static List<Integer> emptyNumbers = List.of();

  @Test
  @DisplayName("should return product of integers")
  void testMultiply() {
    assertEquals(120, Week3Day4.multiply(numbers));
  }

  @Test
  @DisplayName("should return 0 when list contains zero")
  void testMultiplyWithZero() {
    assertEquals(0, Week3Day4.multiply(numbersWithZero));
  }

  @Test
  @DisplayName("should return 0 when empty list")
  void testMultiplyEmpty() {
    assertEquals(0, Week3Day4.multiply(emptyNumbers));
  }

}
