package stream.practices.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week2.Week2Day1.transformNumbers;

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
public class Week2Day1Test {

  @Test
  @DisplayName("should transform numbers")
  void testTransformNumbers() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));

    assertEquals(Arrays.asList(2, 6, 12), transformNumbers(numbers));
  }
}
