package stream.practices.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


enum SortMode {
  ASCENDING, DESCENDING,
}

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */
public class Week3Day1 {
  /*
  Day 1 – Sort a list with sorted()
	• Task: Given a list of integers, return the sorted list.
	• Input: [5, 1, 8, 3, 2]
    Output (ascending): [1, 2, 3, 5, 8]
    Output (descending): [8, 5, 3, 2, 1]
	• Bonus: Sort strings alphabetically.
		○ Input: ["banana", "apple", "pear", "kiwi"]
		○ Output: ["apple", "banana", "kiwi", "pear"]
   */

  // Sort a list by using stream.sorted
  // Support both ascending, and descending modes
  public static <T extends Comparable<? super T>> List<T> sort(List<T> items, SortMode mode) {
    var comparator = new GenericComparator<T>(mode.equals(SortMode.ASCENDING));
    return items.stream().sorted(comparator).toList();
  }

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 5, 4, 3);
    List<String> names = Arrays.asList("Java", "Fast", "Happy");

    System.out.println("Sorting numbers...");
    System.out.println(sort(numbers, SortMode.ASCENDING));
    System.out.println(sort(numbers, SortMode.DESCENDING));

    System.out.println("Sorting strings...");
    System.out.println(sort(names, SortMode.ASCENDING));
    System.out.println(sort(names, SortMode.DESCENDING));
  }
}

class GenericComparator<T extends Comparable<? super T>> implements Comparator<T> {

  private final boolean ascending;

  public GenericComparator(boolean ascending) {
    this.ascending = ascending;
  }

  public static <T extends Comparable<T>> GenericComparator<T> asc() {
    return new GenericComparator<>(true);
  }

  public static <T extends Comparable<T>> GenericComparator<T> desc() {
    return new GenericComparator<>(false);
  }

  @Override
  public int compare(T o1, T o2) {
    if (o1 == null && o2 == null) {
      return 0;
    }
    if (o1 == null) {
      return ascending ? -1 : 1;
    }
    if (o2 == null) {
      return ascending ? 1 : -1;
    }

    int cmp = o1.compareTo(o2);
    return ascending ? cmp : -cmp;
  }
}