class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }

    void display() {
        System.out.println("ID: " + taskId + ", Task: " + taskName + ", Status: " + status);
    }
}

public class Main {
    static Task head = null;

    public static void addTask(Task newTask) {
        newTask.next = head;
        head = newTask;
        System.out.println("Task added.");
    }

    public static void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                current.display();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public static void deleteTask(int id) {
        Task current = head, prev = null;
        while (current != null && current.taskId != id) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Task not found.");
            return;
        }
        if (prev == null)
            head = current.next;
        else
            prev.next = current.next;

        System.out.println("Task deleted.");
    }

    public static void displayTasks() {
        Task current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        addTask(new Task(101, "Design UI", "Pending"));
        addTask(new Task(102, "Write Code", "In Progress"));
        displayTasks();
        searchTask(101);
        deleteTask(102);
        displayTasks();
    }
}
