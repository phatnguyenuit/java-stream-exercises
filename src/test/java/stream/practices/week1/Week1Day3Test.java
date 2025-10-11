package stream.practices.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week1.Week1Day3.filterEvenNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
public class Week1Day3Test {

  @Test
  @DisplayName("should return even numbers")
  void testReturnEvenNumbers() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    assertEquals(Arrays.asList(2, 4), filterEvenNumbers(numbers));
  }
}
