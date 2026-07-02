package employee_ms;

public class EmployeeDirectory {
    private Employee[] employees;
    private int count; // Tracks the actual number of employees in the array

    public EmployeeDirectory(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    // Add a new employee to the end of the list
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Added: " + emp.getName());
        } else {
            System.out.println("Error: Directory is full. Cannot add " + emp.getName());
        }
    }

    // Search for an employee by ID (Linear Search)
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    // Traverse and print all employees
    public void traverseDirectory() {
        if (count == 0) {
            System.out.println("Directory is empty.");
            return;
        }
        System.out.println("\--- Employee Directory ---");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].toString());
        }
    }

    // Delete an employee and shift remaining elements
    public void deleteEmployee(String employeeId) {
        int targetIndex = -1;

        // Step 1: Find the employee
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                targetIndex = i;
                break;
            }
        }

        // Step 2: If found, shift everything over to close the gap
        if (targetIndex != -1) {
            for (int i = targetIndex; i < count - 1; i++) {
                employees[i] = employees[i + 1]; // Move element left
            }
            employees[count - 1] = null; // Clear the last element
            count--;
            System.out.println("Employee ID " + employeeId + " deleted successfully.");
        } else {
            System.out.println("Employee ID " + employeeId + " not found.");
        }
    }

    // Example Usage
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory(5);

        directory.addEmployee(new Employee("E01", "Alice Smith", "Engineer", 85000));
        directory.addEmployee(new Employee("E02", "Bob Jones", "Manager", 95000));
        directory.addEmployee(new Employee("E03", "Charlie Brown", "Analyst", 70000));

        directory.traverseDirectory();

        System.out.println("\nSearching for E02:");
        System.out.println(directory.searchEmployee("E02"));

        System.out.println("\nDeleting E02...");
        directory.deleteEmployee("E02");

        directory.traverseDirectory();
    }
}
