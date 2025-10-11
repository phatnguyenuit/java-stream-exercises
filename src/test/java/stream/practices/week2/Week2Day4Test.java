package stream.practices.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week2.Week2Day4.transformString;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
public class Week2Day4Test {

  @Test
  @DisplayName("should return transformed string")
  void testTransformedString() {
    assertEquals("It's->Fast!", transformString("hi, It's Fast!", 4));
  }
}
