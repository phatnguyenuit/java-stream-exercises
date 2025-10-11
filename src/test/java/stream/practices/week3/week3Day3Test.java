package stream.practices.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week3.Week3Day3.sum;
import static stream.practices.week3.Week3Day3.sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 11:59
 * @project java-stream-exercises
 */
public class week3Day3Test {

  // Test sum integers with reduce and mapToInt().sum()
  final static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  final static List<Integer> emptyNumbers = new ArrayList<>();

  @Nested
  @DisplayName("sum")
  class TestSum {

    @Test
    @DisplayName("should return sum of integers")
    void testSum() {
      assertEquals(15, sum(numbers));
    }

    @Test
    @DisplayName("should return 0 when empty list")
    void testSumEmpty() {
      assertEquals(0, sum(emptyNumbers));
    }
  }

  @Nested
  @DisplayName("sum2")
  class TestSum2 {

    @Test
    @DisplayName("should return sum of integers")
    void testSum() {
      assertEquals(15, sum2(numbers));
    }

    @Test
    @DisplayName("should return 0 when empty list")
    void testSumEmpty() {
      assertEquals(0, sum2(emptyNumbers));
    }
  }
}
