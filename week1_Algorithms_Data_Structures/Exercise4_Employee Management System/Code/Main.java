class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String pos, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + 
                           ", Posit

public class Main {ion: " + position + ", Salary: " + salary);
    }
}
    static Employee[] employees = new Employee[100];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayAll() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Manager", 75000));
        addEmployee(new Employee(2, "Bob", "Developer", 55000));
        displayAll();
        searchEmployee(2);
        deleteEmployee(1);
        displayAll();
    }
}
