package stream.practices.week5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.practices.week5.Week5Day3.Employee;

/**
 * @author PhatNguyen
 * @created 12/10/2025 - 17:38
 * @project java-stream-exercises
 */
public class Week5Day3Test {
  final static Employee alice = new Employee("Alice", "IT", "Developer");
  final static Employee bob = new Employee("Bob", "IT", "Tester");
  final static Employee charlie = new Employee("Charlie", "HR", "Recruiter");
  final static Employee david = new Employee("David", "IT", "Developer");
  final static Employee eva = new Employee("Eva", "HR", "Recruiter");

  final static List<Employee> employees = List.of(alice, bob, charlie, david, eva);

  @Test
  @DisplayName("should group employees by department and then by role")
  void testGroupEmployeesByDepartmentAndRole() {
    Map<String, Map<String, List<String>>> expected = Map.of(
        "IT", Map.of(
            "Developer", List.of("Alice", "David"),
            "Tester", List.of("Bob")
        ),
        "HR", Map.of(
            "Recruiter", List.of("Charlie", "Eva")
        )
    );

    assertEquals(expected, Week5Day3.groupEmployeesByDepartmentAndRole(employees));
  }

  @Test
  @DisplayName("should return an empty map if the input list is empty")
  void testEmptyList() {
    Map<String, Map<String, List<String>>> expected = Map.of();

    assertEquals(expected, Week5Day3.groupEmployeesByDepartmentAndRole(List.of()));
  }

  @Test
  @DisplayName("should return an empty map if the input list is null")
  void testNullList() {
    Map<String, Map<String, List<String>>> expected = Map.of();

    assertEquals(expected, Week5Day3.groupEmployeesByDepartmentAndRole(null));
  }

}
