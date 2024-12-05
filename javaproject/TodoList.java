import java.util.*;

public class TodoList {

    // Define a list to store tasks
    private static List<String> tasks = new ArrayList<>();
    private static List<Boolean> taskStatus = new ArrayList<>();

    // Display menu options
    public static void displayMenu() {
        System.out.println("\n--- Todo List Application ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Add a task to the list
    public static void addTask(String task) {
        tasks.add(task);
        taskStatus.add(false); // New tasks are initially incomplete
    }

    // View all tasks and their statuses
    public static void viewTasks() {
        System.out.println("\n--- Your Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                String status = taskStatus.get(i) ? "[Completed]" : "[Pending]";
                System.out.println((i + 1) + ". " + tasks.get(i) + " " + status);
            }
        }
    }

    // Mark a task as complete
    public static void markTaskComplete(int index) {
        if (index >= 1 && index <= tasks.size()) {
            taskStatus.set(index - 1, true); // Mark task as completed
            System.out.println("Task " + index + " marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main loop for the application
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as complete: ");
                    int taskNumber = scanner.nextInt();
                    markTaskComplete(taskNumber);
                    break;
                case 4:
                    System.out.println("Exiting the To-Do List Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
