package stream.practices.week5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week5.Week5Day2.Person;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 17:20
 * @project java-stream-exercises
 */
public class Week5Day2Test {

  final static Person fast = new Person("Fast Nguyen", 30);
  final static Person tai = new Person("Tai Nguyen", 26);
  final static Person ken = new Person("Ken Do", 30);

  final static List<Person> people = List.of(fast, tai, ken);

  @Test
  @DisplayName("should group people by their age")
  void testGroupPeopleByAge() {
    Map<Integer, List<Person>> expected = Map.ofEntries(
        Map.entry(30, List.of(fast, ken)),
        Map.entry(26, List.of(tai))
    );

    assertEquals(expected, Week5Day2.groupPeopleByAge(people));
  }

  @Test
  @DisplayName("should return an empty map if the input list is empty")
  void testEmptyList() {
    Map<Integer, List<Person>> expected = Map.of();

    assertEquals(expected, Week5Day2.groupPeopleByAge(List.of()));
  }

  @Test
  @DisplayName("should return an empty map if the input list is null")
  void testNullList() {
    Map<Integer, List<Person>> expected = Map.of();

    assertEquals(expected, Week5Day2.groupPeopleByAge(null));
  }
}
