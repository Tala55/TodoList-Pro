import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static TaskList taskList = new TaskList();

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        String str = "\n\n\t\t\t\t\t\t=========== To-Do List ===========\n\n\n";
        str += "\t\t\t\t\t\t1.Add new task\n\t\t\t\t\t\t2.Remove an existing task\n\t\t\t\t\t\t3.Edit a task\n\t\t\t\t\t\t4.Mark a task as completed\n\t\t\t\t\t\t5.List all tasks\n\t\t\t\t\t\t6.Sort tasks by date\n\t\t\t\t\t\t7.Exit\n";
        str += "\n\n\t\t\t\t\t\tEnter your choice: ";
        System.out.print(str);
        int choice = input.nextInt();
        switch (choice) {
            // Add new task:
            case 1:
                Task task1 = new Task();
                System.out.print("\033[H\033[2J");
                taskList.addTask(task1);
                main(null);
                break;
            // Remove an existing task:
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.print("\n\n\t\t\t\t\tEnter the Id of the task to remove: ");
                int taskId = input.nextInt();
                taskList.removeTask(taskId);
                main(null);

                break;
            // Edit a task:
            case 3:
                Date newDate = new Date();
                System.out.print("\033[H\033[2J");
                System.out.print("\n\n\t\t\t\t\tEnter the Id of the task to edit: ");
                int id = input.nextInt();
                System.out.print("\n\t\t\t\t\tEnter new Description: ");
                input.nextLine();
                String description = input.nextLine();
                System.out.print("\n\t\t\t\t\tEnter new Year: ");
                newDate.setYear(input.nextInt());
                System.out.print("\n\t\t\t\t\tEnter new Month: ");
                newDate.setMonth(input.nextInt());
                System.out.print("\n\t\t\t\t\tEnter new Day: ");
                newDate.setDay(input.nextInt());
                taskList.editTask(id, description, newDate);

                main(null);
                break;
            // Mark a task as completed:
            case 4:
                System.out.print("\033[H\033[2J");
                System.out.print("\n\n\t\t\t\t\tEnter Your Id task to mark as completed: ");
                choice = input.nextInt();
                taskList.markTaskAsCompleted(choice);

                main(null);
                break;
            // List all tasks:
            case 5:
                System.out.print("\033[H\033[2J");
                taskList.listTask();
                System.out.print("\n\t\t\t1.Back To main:\n\t\t\t2.Exit\n\n\t\t\tEnter Your choice: ");
                choice = input.nextInt();
                if (choice == 1) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    main(null);
                } else {
                    System.exit(0);
                }

                break;
            // Sort tasks by date:
            case 6:
                System.out.print("\033[H\033[2J");
                taskList.sortTasksByDate();
                main(null);

                break;
            // Exit:
            case 7:
                System.exit(0);
                break;
            default:
        }

    }

}