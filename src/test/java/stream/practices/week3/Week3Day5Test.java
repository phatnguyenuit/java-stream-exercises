package stream.practices.week3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import stream.practices.week3.Week3Day5.Person;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 17:22
 * @project java-stream-exercises
 */
public class Week3Day5Test {

  // Test reduce custom objects
  final static List<Person> people = List.of(
      new Person("Tien", 18),
      new Person("Fast", 30),
      new Person("Mikan", 28),
      new Person("Tano", 26)
  );

  final static List<Person> emptyPeople = List.of();


  @Nested
  @DisplayName("findYoungestPerson")
  class TestYoungestPerson {

    @Test
    @DisplayName("should return the youngest person")
    void testFindYoungestPerson() {
      assertEquals(Optional.of(new Person("Tien", 18)), Week3Day5.findYoungestPerson(people));
    }

    @Test
    @DisplayName("should return empty when no people")
    void testFindYoungestPersonEmpty() {
      assertEquals(Optional.empty(), Week3Day5.findYoungestPerson(emptyPeople));
    }
  }

  @Nested
  @DisplayName("findOldestPerson")
  class TestOldestPerson {

    @Test
    @DisplayName("should return the oldest person")
    void testFindOldestPerson() {
      assertEquals(Optional.of(new Person("Fast", 30)), Week3Day5.findOldestPerson(people));
    }

    @Test
    @DisplayName("should return empty when no people")
    void testFindOldestPersonEmpty() {
      assertEquals(Optional.empty(), Week3Day5.findOldestPerson(emptyPeople));
    }
  }

}
