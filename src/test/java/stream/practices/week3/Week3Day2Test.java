package stream.practices.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream.practices.week3.Week3Day2.comparatorOf;
import static stream.practices.week3.Week3Day2.sort;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
class Week3Day2Test {

  static final List<Person> people = Arrays.asList(
      new Person("Tien", 18),
      new Person("An", 18),
      new Person("Fast", 30)
  );

  @Test
  @DisplayName("should sort object list by attribute in ASC order")
  void testSortObjectListByAttributeAsc() {
    assertEquals(
        Arrays.asList(new Person("An", 18), new Person("Fast", 30), new Person("Tien", 18)),
        sort(people, comparatorOf(Person::name, true))
    );
  }

  @Test
  @DisplayName("should sort object list by attribute in DESC order")
  void testSortObjectListByAttributeDesc() {
    assertEquals(
        Arrays.asList(new Person("Tien", 18), new Person("Fast", 30), new Person("An", 18)),
        sort(people, comparatorOf(Person::name, false))
    );
  }

  @Test
  @DisplayName("should sort object list by none and it is not comparable")
  void testSortObjectListByNone() {
    assertEquals(people, sort(people));
  }

  @Test
  @DisplayName("should sort object list by multiple attributes")
  void testSortObjectListByMultipleAttributes() {
    assertEquals(
        Arrays.asList(new Person("An", 18), new Person("Tien", 18), new Person("Fast", 30)),
        sort(people, comparatorOf(Person::age, true), comparatorOf(Person::name, true))
    );
  }
}
