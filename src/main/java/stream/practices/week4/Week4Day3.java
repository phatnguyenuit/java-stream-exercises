package stream.practices.week4;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 21:59
 * @project java-stream-exercises
 */
public class Week4Day3 {

  /*
  Day 3 – Nested streams (list of objects with inner lists)
	• Task: Extract and flatten inner lists from objects.

	• Class Example:
    class Person {
        String name;
        List<String> hobbies;
    }

	• Input:
    [
      Person("Alice", ["Reading", "Cycling"]),
      Person("Bob", ["Cooking"]),
      Person("Charlie", ["Gaming", "Reading"])
    ]

	• Expected Output (all hobbies in one stream):

    ["Reading", "Cycling", "Cooking", "Gaming", "Reading"]
   */

  public static List<String> flattenHobbies(List<Person> people) {
    return Optional.ofNullable(people)
        .orElse(List.of())
        .stream()
        .map(Person::hobbies)
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .toList();
  }

  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("Fast Nguyen", List.of("Billiards", "Gym")),
        new Person("Tai Nguyen", List.of("Billiards", "Reading"))
    );

    System.out.println(flattenHobbies(people));
  }

  record Person(String name, List<String> hobbies) {

  }
}
