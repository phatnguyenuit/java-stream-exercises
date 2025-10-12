package stream.practices.week5;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 17:38
 * @project java-stream-exercises
 */
public class Week5Day3 {

  /*
  Day 3 – Multi-level grouping (by department, then role)
	• Task: Group employees first by department, then by role.
	• Class Example:
    class Employee {
        String name;
        String department;
        String role;
    }
	• Input:
    [
      Employee("Alice", "IT", "Developer"),
      Employee("Bob", "IT", "Tester"),
      Employee("Charlie", "HR", "Recruiter"),
      Employee("David", "IT", "Developer"),
      Employee("Eva", "HR", "Recruiter")
    ]
	• Expected Output:
    {
      IT = {
        Developer = [Alice, David],
        Tester = [Bob]
      },
      HR = {
        Recruiter = [Charlie, Eva]
      }
    }
   */

  public static <T, K1, K2, V> Map<K1, Map<K2, List<V>>> groupByTwoLevels(List<T> list,
      Function<? super T, ? extends K1> key1, Function<? super T, ? extends K2> key2,
      Function<? super T, ? extends V> valueMapper) {
    return Optional.ofNullable(list)
        .orElse(List.of())
        .stream()
        .collect(Collectors.groupingBy(
            key1,
            Collectors.groupingBy(key2, Collectors.mapping(valueMapper, Collectors.toList()))
        ));
  }

  public static Map<String, Map<String, List<String>>> groupEmployeesByDepartmentAndRole(
      List<Employee> employees) {
    return groupByTwoLevels(employees, Employee::department, Employee::role, Employee::name);
  }

  public static void main(String[] args) {
    List<Employee> employees = List.of(
        new Employee("Fast Nguyen", "IT", "Developer"),
        new Employee("Chau Nguyen", "IT", "Developer"),
        new Employee("Tai Nguyen", "IT", "Developer"),
        new Employee("Phoebe Nguyen", "HR", "Recruiter"),
        new Employee("Jane Trinh", "HR", "Recruiter"),
        new Employee("Lucy Pham", "HR", "Recruiter")
    );

    System.out.println(groupEmployeesByDepartmentAndRole(employees));
  }

  public record Employee(String name, String department, String role) {

  }

}
