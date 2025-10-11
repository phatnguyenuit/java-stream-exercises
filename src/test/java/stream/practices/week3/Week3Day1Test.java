package stream.practices.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week3.Week3Day1.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
class Week3Day1Test {

  static final List<Integer> numbers = Arrays.asList(1, 2, 5, 4, 3);
  static final List<String> strings = Arrays.asList("Happy", "Java", "Fast");

  static Stream<Arguments> sortingArguments() {
    return Stream.of(
        Arguments.of(numbers, SortMode.ASCENDING, Arrays.asList(1, 2, 3, 4, 5)),
        Arguments.of(numbers, SortMode.DESCENDING, Arrays.asList(5, 4, 3, 2, 1)),
        Arguments.of(strings, SortMode.ASCENDING, Arrays.asList("Fast", "Happy", "Java")),
        Arguments.of(strings, SortMode.DESCENDING, Arrays.asList("Java", "Happy", "Fast"))
    );
  }

  @ParameterizedTest
  @DisplayName("should return sorted list following sort mode")
  @MethodSource("sortingArguments")
  void testSortList(List input, SortMode mode, List expected) {
    assertEquals(expected, sort(input, mode));
  }

  /**
   * @author PhatNguyen
   * @created 11/10/2025 - 16:47
   * @project java-stream-exercises
   */
  public static class Week3Day4Test {

  }
}
