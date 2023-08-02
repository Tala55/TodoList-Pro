import java.util.Scanner;

public class TaskList {
    Scanner input = new Scanner(System.in);
    static int i = 0;
    static int count = 0;

    // Array list of Task object
    private Task[] tasks = new Task[10];

    // ------------Add Tasks-----------------
    public void addTask(Task task) {

        if (count > 0) {
            input.nextLine();
        }
        count++;
        System.out.print("\n\n\t\t\t\t\tEnter the description of a task: ");
        task.Description = input.nextLine();
        System.out.print("\n\t\t\t\t\tEnter Year: ");
        task.dueDate.setYear(input.nextInt());
        System.out.print("\n\t\t\t\t\tEnter Month: ");
        task.dueDate.setMonth(input.nextInt());
        System.out.print("\n\t\t\t\t\tEnter Day: ");
        task.dueDate.setDay(input.nextInt());

        tasks[i] = new Task();
        tasks[i].Description = task.Description;
        tasks[i].dueDate.setDay(task.dueDate.getDay());
        tasks[i].dueDate.setMonth(task.dueDate.getMonth());
        tasks[i].dueDate.setYear(task.dueDate.getYear());

        tasks[i].id = i + 1;
        i++;

        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\t\t\t\t\t\tTask Added Successfully");
    }

    // -----------Remove Tasks----------
    public void removeTask(int taskId) {
        if (taskId <= i) {// this if for <not removing> if taskId >i
            for (int j = 0; j < i - 1; j++) {
                if (tasks[j].id == taskId) {
                    tasks[j] = tasks[j + 1];
                    tasks[j].id = tasks[j].id - 1;
                }

            }
            tasks[i - 1] = null;
            --i;

            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tRemoved Successfully");
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tUnsuccessfully progress");
        }

    }

    // ------------Mark Tasks------------
    public void markTaskAsCompleted(int taskId) {
        if (taskId <= i) {
            for (int j = 0; j < i; j++) {
                if (tasks[j].id == taskId) {
                    tasks[j].isCompleted = true;
                }
            }
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tMarked Successfully");
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tMarked Unsuccessfully");
        }

    }

    // ---------Show All Tasks-----------
    public void listTask() {
        String str = "\n\n\t\t\tID\t\t\tTask\t\t\tDate\t\t\tStatus\n\t\t\t---\t\t\t----\t\t\t----\t\t\t------\n\n\t\t\t";
        for (int j = 0; j < i; j++) {

            str += tasks[j].id + "\t\t\t" + tasks[j].Description
                    + (tasks[j].Description.length() >= 8 ? tasks[j].Description.length() >= 15 ? "\t" : "\t\t"
                            : "\t\t\t")
                    + tasks[j].dueDate.toString() + "\t\t"
                    + (tasks[j].isCompleted == true ? "Completed" : "In progress");
            str += "\n\t\t\t";
        }
        System.out.println(str);

    }

    // ----------Sorting------------
    public void sortTasksByDate() {
        for (int j = 0; j < i - 1; j++) {
            for (int k = j + 1; k < i - 1; k++) {
                if (tasks[j].dueDate.getYear() > tasks[k].dueDate.getYear()) {
                    Task temp = tasks[j];
                    tasks[j] = tasks[k];
                    tasks[k] = temp;
                } else if (tasks[j].dueDate.getYear() == tasks[k].dueDate.getYear()) {
                    if (tasks[j].dueDate.getMonth() > tasks[k].dueDate.getMonth()) {
                        Task temp = tasks[j];
                        tasks[j] = tasks[k];
                        tasks[k] = temp;
                    } else if (tasks[j].dueDate.getMonth() == tasks[k].dueDate.getMonth()) {
                        if (tasks[j].dueDate.getDay() > tasks[k].dueDate.getDay()) {
                            Task temp = tasks[j];
                            tasks[j] = tasks[k];
                            tasks[k] = temp;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < i; j++) {
            tasks[j].id = j + 1;
        }
        System.out.println("\n\n\t\t\t\t\t\tSorted Successfully");

    }

    // -----------Editing-----------------
    public void editTask(int taskId, String newDescription, Date newDueDate) {
        if (taskId <= i) {
            for (int j = 0; j < i; j++) {
                if (tasks[j].id == taskId) {
                    tasks[j].Description = newDescription;
                    tasks[j].dueDate = newDueDate;
                    tasks[j].isCompleted = false;
                }
            }
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tEdited Successfully");

        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tEdited Unsuccessfully");

        }

    }

}
