package stream.practices.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week3Day2 {
  /*
  Day 2 – Sort custom objects by field
	• Task: Sort Person objects.
	• Class: Person(name, age)
	• Input:
    [Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35)]
	• Output (by name): [Alice(30), Bob(25), Charlie(35)]
	• Output (by age ascending): [Bob(25), Alice(30), Charlie(35)]
	• Output (by age, then name): [Bob(25), Alice(30), Charlie(35)] (if ages tie, order by name).
   */

  // TODO: Sort a list by using stream.sorted
  // Support both ascending, and descending modes
  // sort by multiple comparators
  public static <T, U extends Comparable<? super U>> Comparator<T> comparatorOf(
      Function<T, U> keyExtractor, boolean isAscending) {

    return Comparator.comparing(
        keyExtractor,
        isAscending ? Comparator.naturalOrder() : Comparator.reverseOrder()
    );
  }

  @SafeVarargs
  @SuppressWarnings("unchecked")
  public static <T> Comparator<T> chainComparators(Comparator<T>... comparators) {
    return Stream.of(comparators)
        .reduce(Comparator::thenComparing)
        // fallback when no comparators provided
        .orElse((o1, o2) -> {
          if (o1 instanceof Comparable && o2 instanceof Comparable) {
            return ((Comparable<T>) o1).compareTo(o2);
          }
          return 0;
        });
  }

  @SafeVarargs
  public static <T> List<T> sort(List<T> items, Comparator<T>... comparators) {
    return items.stream().sorted(chainComparators(comparators)).toList();
  }

  public static void main(String[] args) {
    List<Person> people = Arrays.asList(
        new Person("Fast", 30),
        new Person("Tien", 18),
        new Person("An", 18),
        new Person("Mikan", 28),
        new Person("Tano", 26)
    );

    System.out.println("Sorting by name");
    System.out.println(sort(people, comparatorOf(Person::name, true)));

    System.out.println("Sorting by age descending");
    System.out.println(sort(people, comparatorOf(Person::age, false)));

    System.out.println("Sorting by age and name");
    System.out.println(sort(
        people,
        comparatorOf(Person::age, true),
        comparatorOf(Person::name, true)
    ));
  }
}

record Person(String name, int age) {

}

