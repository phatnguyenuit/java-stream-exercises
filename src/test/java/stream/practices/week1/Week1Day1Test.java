package stream.practices.week1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
public class Week1Day1Test {

  @Test
  @DisplayName("should print stream elements")
  void testPrintStreamElements() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    assertDoesNotThrow(() -> Week1Day1.printStreamElements(numbers));
  }
}
