package stream.practices.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week2.Week2Day5.calculateAverage;
import static stream.practices.week2.Week2Day5.calculateTotal;
import static stream.practices.week2.Week2Day5.countLongWords;
import static stream.practices.week2.Week2Day5.countWordsByFirstCharacter;
import static stream.practices.week2.Week2Day5.findMaxModuloOfNumberGroups;
import static stream.practices.week2.Week2Day5.groupAverageSalaryPerDepartment;
import static stream.practices.week2.Week2Day5.groupByFirstCharacter;
import static stream.practices.week2.Week2Day5.groupNumbers;
import static stream.practices.week2.Week2Day5.groupTotalAmountPerType;
import static stream.practices.week2.Week2Day5.groupTotalNumbers;
import static stream.practices.week2.Week2Day5.summarizeData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stream.practices.week2.Week2Day5.Employee;
import stream.practices.week2.Week2Day5.NumberParity;
import stream.practices.week2.Week2Day5.Transaction;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
public class Week2Day5Test {

  public static final List<Integer> values = Arrays.asList(1, 2, 9, 4, 5);

  @Nested
  @DisplayName("countLongWords")
  class CountLongWordsTest {

    @Test
    @DisplayName("should return number of long words")
    void testCountLongWords() {
      assertEquals(4, countLongWords("Hi where are you today?", 3));
    }
  }

  @Nested
  @DisplayName("calculateAverage")
  class CalculateAverageTest {

    @Test
    @DisplayName("should return average value")
    void testAverageValue() {
      assertEquals(4.2, calculateAverage(values));
    }
  }

  @Nested
  @DisplayName("calculateTotal")
  class CalculateTotalTest {

    @Test
    @DisplayName("should return total result")
    void testTotal() {
      assertEquals(21, calculateTotal(values));
    }
  }

  @Nested
  @DisplayName("summarizeData")
  class SummarizeDataTest {

    @Test
    @DisplayName("should return correct summarize result")
    void testSummarizeResult() {
      var result = summarizeData(values);

      assertEquals(5, result.getCount());
      assertEquals(21, result.getSum());
      assertEquals(9, result.getMax());
      assertEquals(1, result.getMin());
      assertEquals(4.2, result.getAverage());
    }
  }

  @Nested
  @DisplayName("countWordsByFirstCharacter")
  class CountWordsByFirstCharacterTest {

    @Test
    @DisplayName("should return correct word count by first character")
    void testWordCountByFirstCharacter() {
      var result = countWordsByFirstCharacter("hi hello ok?");

      assertEquals(2, result.get('h'));
      assertEquals(1, result.get('o'));
    }
  }

  @Nested
  @DisplayName("groupByFirstCharacter")
  class GroupByFirstCharacterTest {

    @Test
    @DisplayName("should return list of words group by first character")
    void testGroupByFirstCharacter() {
      var result = groupByFirstCharacter(Arrays.asList("banana", "apple", "avocado"));

      assertEquals(Arrays.asList("apple", "avocado"), result.get('a'));
      assertEquals(List.of("banana"), result.get('b'));
    }
  }

  @Nested
  @DisplayName("groupNumbers")
  class GroupNumbersTest {

    @Test
    @DisplayName("should return groups of numbers")
    void testGroupNumbers() {
      var result = groupNumbers(Arrays.asList(1, 2, 3));

      assertEquals(Arrays.asList(1, 3), result.get("odd"));
      assertEquals(List.of(2), result.get("even"));
    }
  }

  @Nested
  @DisplayName("groupTotalNumbers")
  class GroupTotalNumbersTest {

    static Stream<Arguments> numbersProvider() {
      return Stream.of(
          Arguments.of(
              "having empty list",
              List.of(),
              Map.ofEntries(Map.entry(NumberParity.ODD, 0), Map.entry(NumberParity.EVEN, 0))
          ), Arguments.of(
              "having only odd numbers",
              Arrays.asList(1, 3),
              Map.ofEntries(Map.entry(NumberParity.ODD, 4), Map.entry(NumberParity.EVEN, 0))
          ), Arguments.of(
              "having only even numbers",
              Arrays.asList(2, 4),
              Map.ofEntries(Map.entry(NumberParity.ODD, 0), Map.entry(NumberParity.EVEN, 6))
          ), Arguments.of(
              "having both even and odd numbers",
              Arrays.asList(1, 2, 3),
              Map.ofEntries(Map.entry(NumberParity.ODD, 4), Map.entry(NumberParity.EVEN, 2))
          )
      );
    }

    @DisplayName("should return total of each group numbers")
    @MethodSource("numbersProvider")
    @ParameterizedTest(name = "when {0}")
    void testGroupTotalNumbers(String context, List<Integer> input,
        Map<NumberParity, Integer> expected) {
      System.out.println("Testing context: " + context + " ...");
      assertEquals(expected, groupTotalNumbers(input));
    }
  }

  @Nested
  @DisplayName("findMaxModuloOfNumberGroups")
  class FindMaxModuloOfNumberGroupsTest {

    @Test
    @DisplayName("should return max number for each modulo group of 3")
    void testMaxModuloOfNumberGroups() {
      var result = findMaxModuloOfNumberGroups(Arrays.asList(1, 2, 3, 9, 11, 10));
      var expected = Map.ofEntries(Map.entry(0, 9), Map.entry(1, 10), Map.entry(2, 11));

      assertEquals(expected, result);
    }
  }

  @Nested
  @DisplayName("groupAverageSalaryPerDepartment")
  class GroupAverageSalaryPerDepartmentTest {

    @Test
    @DisplayName("should return average salary per department")
    void testAverageSalaryPerDepartment() {
      List<Employee> employees = Arrays.asList(
          new Employee("Fast", "IT", 60.5),
          new Employee("Tano", "IT", 32),
          new Employee("Jasmine", "Sales", 20),
          new Employee("Lucy", "Sales", 18.5)
      );
      var result = groupAverageSalaryPerDepartment(employees);
      var expected = Map.ofEntries(Map.entry("IT", 46.25), Map.entry("Sales", 19.25));

      assertEquals(expected, result);
    }
  }

  @Nested
  @DisplayName("groupTotalAmountPerType")
  class GroupTotalAmountPerTypeTest {

    @Test
    @DisplayName("should return total amount per transaction type")
    void testTotalAmountPerTransactionType() {
      List<Transaction> transactions = Arrays.asList(
          new Transaction("deposit", 200),
          new Transaction("withdraw", 35.5),
          new Transaction("credit", 100),
          new Transaction("deposit", 500),
          new Transaction("withdraw", 120),
          new Transaction("deposit", 200)
      );
      var result = groupTotalAmountPerType(transactions);
      var expected = Map.ofEntries(
          Map.entry("deposit", 900.0),
          Map.entry("credit", 100.0),
          Map.entry("withdraw", 155.5)
      );

      assertEquals(expected, result);
    }
  }
}
