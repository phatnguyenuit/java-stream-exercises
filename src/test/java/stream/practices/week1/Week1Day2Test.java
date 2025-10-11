package stream.practices.week1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week1.Week1Day2.toSquare;

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
public class Week1Day2Test {

  @Test
  @DisplayName("should return square numbers")
  void testReturnSquareNumbers() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    assertEquals(Arrays.asList(1, 4, 9, 16, 25), toSquare(numbers));
  }
}
