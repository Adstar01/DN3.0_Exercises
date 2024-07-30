package Exercise4;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[size] = employee;
        size++;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Bob", "Developer", 55000));
        ems.addEmployee(new Employee("E003", "Charlie", "Designer", 50000));

        System.out.println("Employee List:");
        ems.traverseEmployees();

        System.out.println("\nSearching for Employee E002:");
        Employee emp = ems.searchEmployee("E002");
        System.out.println(emp != null ? emp : "Employee not found");

        System.out.println("\nDeleting Employee E002:");
        ems.deleteEmployee("E002");

        System.out.println("\nEmployee List after Deletion:");
        ems.traverseEmployees();
    }
}

