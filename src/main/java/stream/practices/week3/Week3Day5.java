package stream.practices.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 16:51
 * @project java-stream-exercises
 */
public class Week3Day5 {
  /*
  Day 5 – Reduce custom objects (find oldest person)
	• Task: Use reduce() to find the oldest person.
	• Input:
    [Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35)]
	• Output (oldest): Person("Charlie", 35)
	• Bonus: Youngest → Person("Bob", 25)
	• Empty list case: [] → Optional.empty.
   */

  // Reduce custom objects
  public static Optional<Person> findYoungestPerson(List<Person> people) {
    return people.stream().reduce((a, b) -> a.age < b.age ? a : b);
  }

  public static Optional<Person> findOldestPerson(List<Person> people) {
    return people.stream().reduce((a, b) -> a.age > b.age ? a : b);
  }

  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("Tien", 18),
        new Person("Fast", 30),
        new Person("Mikan", 28),
        new Person("Tano", 26)
    );

    System.out.println(findYoungestPerson(people));
    System.out.println(findYoungestPerson(new ArrayList<>()));

    System.out.println(findOldestPerson(people));
    System.out.println(findOldestPerson(new ArrayList<>()));

  }

  record Person(String name, int age) {

  }

}