package stream.practices.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author PhatNguyen
 * @created 20/09/2025 - 11:01
 * @project java-stream-exercises
 */


public class Week2Day5 {
  /*
  Day 5 – Collect with counting(), averagingInt(), etc.
	• Input:
    [10, 20, 30, 40]
	• Expected Output:
    counting() → 4
    averagingInt() → 25.0
    summingInt() → 100
    maxBy() → 40
    minBy() → 10

   */

  // Using stream.collect(Collectors.counting()), or stream.count()
  public static long countLongWords(String str, int minLength) {
//    return Arrays.stream(str.split(" ")).filter(s -> s.length() >= minLength).count();
    return Arrays.stream(str.split(" "))
        .filter(s -> s.length() >= minLength)
        .collect(Collectors.counting());

  }

  // Using stream.collect(Collectors.averagingInt())
  public static double calculateAverage(List<Integer> values) {
    return values.stream().collect(Collectors.averagingInt(Integer::intValue));
  }

  // Using stream.collect(Collectors.summingInt()), or mapToInt(Integer::intValue).sum()
  public static int calculateTotal(List<Integer> values) {
//    return values.stream().mapToInt(Integer::intValue).sum();
    return values.stream().collect(Collectors.summingInt(Integer::intValue));
  }

  public static Map<Character, Long> countWordsByFirstCharacter(String str) {
    Stream<String> stream = Arrays.stream(str.toLowerCase().split(" "));

    return stream.collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
  }

  public static IntSummaryStatistics summarizeData(List<Integer> values) {
    return values.stream().collect(Collectors.summarizingInt(Integer::intValue));
  }

  public static Map<Character, List<String>> groupByFirstCharacter(List<String> words) {
    return words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
  }

  public static Map<String, List<Integer>> groupNumbers(List<Integer> numbers) {
    return numbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
  }

  public static EnumMap<NumberParity, Integer> groupTotalNumbers(List<Integer> numbers) {
    EnumMap<NumberParity, Integer> result = numbers.stream().collect(Collectors.groupingBy(
        n -> n % 2 == 0 ? NumberParity.EVEN : NumberParity.ODD,
        () -> new EnumMap<>(NumberParity.class),
        Collectors.summingInt(Integer::intValue)
    ));

    for (NumberParity numberParity : NumberParity.values()) {
      // result.putIfAbsent(numberParity, 0);
      if (!result.containsKey(numberParity)) {
        result.put(numberParity, 0);
      }
    }

    return result;
  }

  public static Map<Integer, Integer> findMaxModuloOfNumberGroups(List<Integer> numbers) {
    return numbers.stream().collect(Collectors.groupingBy(
        n -> n % 3,
        // as we sure we always have value, so we can use Optional.get explicitly
        Collectors.collectingAndThen(Collectors.maxBy(Integer::compareTo), Optional::get)

    ));
  }

  public static Map<String, Double> groupAverageSalaryPerDepartment(List<Employee> employees) {
    return employees.stream()
        .collect(Collectors.groupingBy(
            Employee::department,
            Collectors.averagingDouble(Employee::salary)
        ));
  }

  public static Map<String, Double> groupTotalAmountPerType(List<Transaction> transactions) {
    return transactions.stream()
        .collect(Collectors.groupingBy(
            Transaction::type,
            Collectors.summingDouble(Transaction::amount)
        ));
  }

  public static Map<String, Map<String, List<Person>>> groupPeopleByCityAndAge(
      List<Person> people) {
    return people.stream()
        .collect(Collectors.groupingBy(Person::city, Collectors.groupingBy(Person::ageCategory)));
  }

  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 9, 4, 5);
    List<Employee> employees = Arrays.asList(
        new Employee("Fast", "IT", 60),
        new Employee("Tano", "IT", 32),
        new Employee("Josh", "Sales", 15),
        new Employee("Lewis", "Sales", 12.5)
    );
    List<Transaction> transactions = Arrays.asList(
        new Transaction("deposit", 200),
        new Transaction("withdraw", 35.5),
        new Transaction("credit", 100),
        new Transaction("deposit", 500),
        new Transaction("withdraw", 120),
        new Transaction("deposit", 200)
    );
    List<Person> people = Arrays.asList(
        new Person("Fast", "HCM", 30),
        new Person("Tano", "HCM", 26),
        new Person("An", "HCM", 18),
        new Person("Mikan", "HCM", 28),
        new Person("Grace", "TN", 55),
        new Person("Nick", "TN", 11)
    );

    System.out.println(countLongWords("Hi where are you today?", 3));
    System.out.println(countWordsByFirstCharacter("hi hello ok?"));

    System.out.println(calculateAverage(values));
    System.out.println(calculateTotal(values));
    System.out.println(summarizeData(values));

    System.out.println(groupByFirstCharacter(Arrays.asList(
        "apple",
        "banana",
        "cherry",
        "lemon",
        "avocado",
        "coconut",
        "blueberry"
    )));

    System.out.println(groupNumbers(values));
    System.out.println(groupTotalNumbers(values));
    System.out.println(findMaxModuloOfNumberGroups(Arrays.asList(3, 4, 5, 9, 10, 11)));

    System.out.println(groupAverageSalaryPerDepartment(employees));
    System.out.println(groupTotalAmountPerType(transactions));
    System.out.println(groupPeopleByCityAndAge(people));

    System.out.println("Find the employee name having max salary per department");
    System.out.println(employees.stream().collect(Collectors.groupingBy(
        Employee::department,
        Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
            e -> e.map(Employee::name).orElse(null)
        )
    )));

    System.out.println("Find top 3 employees sharing the maximum salary");
    System.out.println(employees.stream()
        .sorted(Comparator.comparingDouble(Employee::salary).reversed())
        .limit(3)
        .map(Employee::name)
        .toList());

    System.out.println("Using custom collectors:");
    System.out.println("joining");
    System.out.println(Arrays.asList("Hello", "World")
        .stream()
        .collect(CustomCollectors.joining("->")));

    System.out.println("product");
    System.out.println(values.stream().collect(CustomCollectors.product()));
//    System.out.println(values.parallelStream().collect(CustomCollectors.product()));

    System.out.println(values.stream().collect(CustomCollectors.toMinMax()));
    System.out.println(new ArrayList<Integer>().stream().collect(CustomCollectors.toMinMax()));
  }

  enum NumberParity {
    EVEN, ODD
  }

  public static class CustomCollectors {

    public static Collector<String, StringBuilder, String> joining(String delimiter) {
      return Collector.of(
          // 1️⃣ Supplier → start with empty StringBuilder
          StringBuilder::new,

          // 2️⃣ Accumulator → append string with delimiter if needed
          (sb, str) -> {
            if (sb.length() > 0) {
              sb.append(delimiter);
            }
            sb.append(str);
          },

          // 3️⃣ Combiner → merge two StringBuilders (for parallel streams)
          (sb1, sb2) -> {
            if (sb1.length() == 0) {
              return sb2;
            }
            if (sb2.length() == 0) {
              return sb1;
            }
            sb1.append(delimiter).append(sb2);
            return sb1;
          },

          // 4️⃣ Finisher → convert StringBuilder to String
          StringBuilder::toString
      );
    }

    public static Collector<Integer, int[], Integer> product() {
      return Collector.of(
          // 1️⃣ Supplier → start with an array of size 1 holding the initial product = 1
          () -> new int[]{1},

          // 2️⃣ Accumulator → multiply current product by new value
          (acc, n) -> acc[0] *= n,

          // 3️⃣ Combiner → multiply partial products (for parallel streams)
          (acc1, acc2) -> {
            acc1[0] *= acc2[0];
            return acc1;
          },

          // 4️⃣ Finisher → unwrap from array to single Integer
          acc -> acc[0]
      );
    }

    public static Collector<Integer, MinMax, MinMax> toMinMax() {
      return Collector.of(
          MinMax::new,                      // supplier
          MinMax::accept,                   // accumulator
          MinMax::combine,                  // combiner
          Characteristics.UNORDERED // characteristics
      );
    }
  }


  record Employee(String name, String department, double salary) {

  }

  record Transaction(String type, double amount) {

  }

  record Person(String name, String city, int age) {

    public String ageCategory() {
      if (this.age < 30) {
        return "young";
      }
      if (this.age <= 50) {
        return "middle";
      }

      return "senior";
    }
  }


}

class MinMax {

  private int min = Integer.MAX_VALUE;
  private int max = Integer.MIN_VALUE;

  public void accept(int value) {
    if (value < min) {
      min = value;
    }
    if (value > max) {
      max = value;
    }
  }

  public MinMax combine(MinMax other) {
    MinMax result = new MinMax();
    result.min = Math.min(this.min, other.min);
    result.max = Math.max(this.max, other.max);
    return result;
  }

  public OptionalInt getMin() {
    return min == Integer.MAX_VALUE ? OptionalInt.empty() : OptionalInt.of(min);
  }

  public OptionalInt getMax() {
    return max == Integer.MIN_VALUE ? OptionalInt.empty() : OptionalInt.of(max);
  }

  @Override
  public String toString() {
    return "MinMax{" + "min=" + getMin() + ", max=" + getMax() + '}';
  }
}

