package stream.practices.week5;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 17:20
 * @project java-stream-exercises
 */
public class Week5Day2 {
  /*
  Day 2 – Group people by age
	• Task: Group people by their exact age.
	• Class Example:
    class Person {
        String name;
        int age;
    }
	• Input:
    [
      Person("Alice", 30),
      Person("Bob", 25),
      Person("Charlie", 30),
      Person("David", 25)
    ]
	• Expected Output:
    {
      25 = [Bob(25), David(25)],
      30 = [Alice(30), Charlie(30)]
    }
   */

  public static Map<Integer, List<Person>> groupPeopleByAge(List<Person> people) {
    return Optional.ofNullable(people)
        .orElse(List.of())
        .stream()
        .collect(Collectors.groupingBy(Person::age));
  }

  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("Fast Nguyen", 30),
        new Person("Tai Nguyen", 26),
        new Person("Ken Do", 30)
    );

    System.out.println(groupPeopleByAge(people));
  }

  public record Person(String name, int age) {

  }
}
