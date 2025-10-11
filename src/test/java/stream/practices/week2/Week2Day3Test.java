package stream.practices.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week2.Week2Day3.countWordFrequency;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
public class Week2Day3Test {

  @Test
  @DisplayName("should count word frequency")
  void testCountWordFrequency() {
    var expected = Map.ofEntries(
        Map.entry("One", 1),
        Map.entry("is", 2),
        Map.entry("1", 1),
        Map.entry("and", 1),
        Map.entry("two", 1),
        Map.entry("2", 1)
    );
    assertEquals(expected, countWordFrequency("One is 1 and two is 2"));
  }
}
