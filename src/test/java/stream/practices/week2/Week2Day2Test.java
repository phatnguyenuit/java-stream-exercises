package stream.practices.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week2.Week2Day2.getUniqueNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
public class Week2Day2Test {

  @Test
  @DisplayName("should return a set of unique numbers")
  void testUniqueNumbers() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));

    assertEquals(new HashSet<>(Arrays.asList(1, 2, 3)), getUniqueNumbers(numbers));
  }
}
