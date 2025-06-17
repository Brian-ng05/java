package TaskManagement.V02;

import java.util.Scanner;
class Task {
    int id;
    String desc;
    char priority;
    boolean isCompleted;

    public Task(int id, String desc, char priority){
        this.id = id;
        this.desc = desc;
        this.priority = priority;
        this.isCompleted= false;
   }
   @Override
    public String toString(){
        return "ID: " + id + " Priority: " + priority + "               Description: " + desc;
   }
}

public class TaskManagement {
    static ArrayListADT<Task> tasks = new ArrayListADT<>();
    static ArrayListADT<Task> completedTasks = new ArrayListADT<>();
    static boolean running = true;
    static int counter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String[] menu = {
                    "Task Management Application",
                    "------------",
                    "1. Add a task",
                    "2. Display all tasks",
                    "3. Complete a task",
                    "4. Display all completed tasks",
                    "5. Exit"
            };
            for (String i : menu) {
                System.out.println(i);
            }
            System.out.println();
            System.out.print("Please enter your option: ");
            String userChoice = sc.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Enter the task description: ");
                    String desc = sc.nextLine();
                    char priority;
                    while (true) {
                        System.out.print("Enter the task priority [A/B/C]: ");
                        String input = sc.nextLine().trim().toUpperCase();

                        if ((input.startsWith("A") || input.startsWith("B") || input.startsWith("C"))) {
                            priority = input.charAt(0);
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter only A, B, or C.");
                        }
                    }
                    Task task = new Task(counter, desc, priority);
                    tasks.add(task);
                    System.out.println("Task added successfully\n");
                    counter++;
                    break;
                case "2":
                    if (tasks.isEmpty()){
                        System.out.println("No tasks to display.");
                    } else {
                        System.out.println("All tasks:");

                        char[] order = {'A', 'B', 'C'};
                            for (char p : order) {
                                for (int t = 0; t < tasks.size(); t++) {
                                    if (tasks.get(t).priority == p) {
                                        System.out.println(tasks.get(t));

//                                    for (int i = 0; i < tasks.size(); i++) {
//                                        System.out.println(tasks.get(i));
//                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "3":
                    int numCompleted;
                    while (true) {
                        System.out.print("Enter ID of task to mark as completed: ");
                        String input = sc.nextLine().trim();

                        if (input.isEmpty()) {
                            System.out.println("Input cannot be empty. Please enter a task ID.\n");
                            continue;
                        }

                        try {
                            numCompleted = Integer.parseInt(input);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid numeric task ID.\n");
                        }
                    }
                    boolean found = false;
                    for (int i = 0; i < tasks.size(); i++) {
                        if (tasks.get(i).id == numCompleted) {
                            if (tasks.get(i).isCompleted) {
                                System.out.println("Task is already marked as completed.\n");
                            } else {
                                tasks.get(i).isCompleted = true;
                                completedTasks.add(tasks.get(i));
                                System.out.println("Task marked as completed.\n");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Task with ID " + numCompleted + " not found.\n");
                    }
                    break;
                case "4":
                    if (completedTasks.isEmpty()) {
                        System.out.println("Completed tasks not found");
                    }
                    else {
                        System.out.println("Completed tasks:");
                        for (int i = 0; i < completedTasks.size(); i++) {
                            System.out.println(completedTasks.get(i));
                        }
                    }
                        System.out.println();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option (1-5).\n");
                    System.out.println("Invalid option. Please select a valid option (1-5).\n");
                    System.out.println("Invalid option. Please select a valid option (1-5).\n");
                    break;
            }
        } while (running);
    }
}