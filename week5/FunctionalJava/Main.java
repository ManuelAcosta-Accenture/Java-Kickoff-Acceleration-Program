
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ana", "IT", 50000),
                new Employee(2, "Luis", "HR", 30000),
                new Employee(3, "Pedro", "IT", 60000),
                new Employee(4, "Maria", "Sales", 40000),
                new Employee(5, "Juan", "HR", 35000),
                new Employee(6, "Sofia", "IT", 70000),
                new Employee(7, "Carlos", "Sales", 45000),
                new Employee(8, "Ana", "IT", 50000)
        );

        // 1. Find highest salary
        double highestSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);

        System.out.println("Highest salary: " + highestSalary);


        // 2. Group employees by department
        Map<String, List<Employee>> groups = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees by department:");
        System.out.println(groups);


        // 3. Calculate average salary
        double average = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("\nAverage salary: " + average);


        // 4. Find duplicate records (same name)
        Set<String> names = new HashSet<>();

        List<Employee> duplicates = employees.stream()
                .filter(e -> !names.add(e.getName()))
                .collect(Collectors.toList());

        System.out.println("\nDuplicates:");
        System.out.println(duplicates);


        // 5. Convert objects into maps
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        e -> e
                ));

        System.out.println("\nEmployee map:");
        System.out.println(employeeMap);


        // 6. Partition employees by salary
        Map<Boolean, List<Employee>> partition = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() > 45000
                ));

        System.out.println("\nSalary partition:");
        System.out.println(partition);


        // 7. Find top 5 employees
        List<Employee> top5 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 employees:");
        top5.forEach(System.out::println);
    }
}
