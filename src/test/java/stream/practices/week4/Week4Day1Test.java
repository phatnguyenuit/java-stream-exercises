package stream.practices.week4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 18:26
 * @project java-stream-exercises
 */
public class Week4Day1Test {

  List<List<Integer>> numbers = Arrays.asList(
      Arrays.asList(1, 2, 3),
      Arrays.asList(4, 5),
      List.of(6)
  );
  List<List<Integer>> emptyNumbers = List.of();

  @Test
  @DisplayName("should flatten list of list numbers")
  void testFlattenLists() {
    assertEquals(List.of(1, 2, 3, 4, 5, 6), Week4Day1.flatten(numbers));
  }

  @Test
  @DisplayName("should flatten empty list")
  void testFlattenEmptyList() {
    assertEquals(List.of(), Week4Day1.flatten(emptyNumbers));
  }
}
