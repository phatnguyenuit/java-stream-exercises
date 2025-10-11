package stream.practices.week4;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.practices.week4.Week4Day3.Person;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 22:04
 * @project java-stream-exercises
 */
public class Week4Day3Test {

  // Test nested streams (list of objects with inner lists)
  final static List<Person> people = List.of(
      new Person("Alice", List.of("Reading", "Cycling")),
      new Person("Bob", List.of("Cooking")),
      new Person("Charlie", List.of("Gaming", "Reading"))
  );

  final static List<Week4Day3.Person> peopleWithNullHobbies = List.of(
      new Person("Alice", List.of("Reading", "Cycling")),
      new Person("Bob", null),
      new Person("Charlie", List.of("Gaming", "Reading"))
  );

  final static List<Person> emptyPeople = List.of();

  @Test
  @DisplayName("should flatten hobbies from a list of people")
  void testFlattenHobbies() {
    assertEquals(
        List.of("Reading", "Cycling", "Cooking", "Gaming", "Reading"),
        Week4Day3.flattenHobbies(people)
    );
  }

  @Test
  @DisplayName("should flatten hobbies and handle null hobby lists")
  void testFlattenHobbiesWithNullHobbies() {
    assertEquals(
        List.of("Reading", "Cycling", "Gaming", "Reading"),
        Week4Day3.flattenHobbies(peopleWithNullHobbies)
    );
  }

  @Test
  @DisplayName("should return empty list when input people list is empty")
  void testFlattenEmptyPeople() {
    assertEquals(List.of(), Week4Day3.flattenHobbies(emptyPeople));
  }

  @Test
  @DisplayName("should return empty list when input people list is null")
  void testFlattenNullPeople() {
    assertEquals(List.of(), Week4Day3.flattenHobbies(null));
  }

}
