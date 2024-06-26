/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.addingtaskfeature;

/**
 *
 * @author brook
 */
import java.util.Scanner;

public class Addingtaskfeature {
    public static void main(String[] args, Task[] Addingtaskfeature) {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false; // Flag to track login status
        String choice;

        do {
            System.out.println("Please choose an option:");
            System.out.println("(1) Log in");
            System.out.println("(2) Add a task");
            System.out.println("(0) Exit");

            choice = input.nextLine();

            switch (choice) {
                case "1":
                    // Simulate login (you can replace this with actual authentication logic)
                    System.out.println("Enter your username:");
                    String username = input.nextLine();
                    System.out.println("Enter your password:");
                    String password = input.nextLine();

                    // Check if login is successful (For now, the login process was true)
                    loggedIn = true;
                    System.out.println("Welcome to Easykanban");
                    break;

                case "2":
                    if (loggedIn) {
                        // Only allow adding tasks if logged in
                        System.out.println("Enter the task description:");
                        String taskDescription = input.nextLine();
                        System.out.println("Task added: " + taskDescription);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case "0":
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Error! Please try again.");
            }
        } while (!choice.equals("0"));
        
        do {
            System.out.println("Please choose an option:");
            System.out.println("1. Add tasks");
            System.out.println("2. Coming Soon");
            System.out.println("3. Quit");

            choice = input.nextLine();

            switch (choice) {
                case "1":
                    if (loggedIn) {
                        // Only allow adding tasks if logged in
                        System.out.println("Enter the task description:");
                        String taskDescription = input.nextLine();
                        System.out.println("Task added: " + taskDescription);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case "2":
                    // Placeholder for showing report (you can implement this feature)
                    System.out.println("Showing report (not implemented yet).");
                    break;

                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("3"));
        
        
         System.out.print("Enter the number of tasks you wish to enter: ");
        int numTasks = input.nextInt();
        input.nextLine(); // Consume newline

        String[] tasks = new String[numTasks];

        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tasks[i] = input.nextLine();
        }

        System.out.println("\nTasks entered:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
        
         

        for (int i = 0; i < numTasks; i++) {
            System.out.println("\nTask " + (i + 1));
            System.out.print("Task Name: ");
            String taskName = input.nextLine();
            System.out.print("Task Description (max 50 characters): ");
            String taskDescription = input.nextLine();
            System.out.print("Developer First Name: ");
            String firstName = input.nextLine();
            System.out.print("Developer Last Name: ");
            String lastName = input.nextLine();
            System.out.print("Task Duration (hours): ");
            double duration = input.nextDouble();
            input.nextLine(); // Consume newline

            // Generate Task ID
            String taskID = generateTaskID(taskName, i, lastName);

            // Select Task Status
            System.out.println("Select Task Status:");
            System.out.println("1. To Do");
            System.out.println("2. Done");
            System.out.println("3. Doing");
            int statusChoice = input.nextInt();
            input.nextLine(); // Consume newline
            String taskStatus;
            switch (statusChoice) {
                case 1:
                    taskStatus = "To Do";
                    break;
                case 2:
                    taskStatus = "Done";
                    break;
                case 3:
                    taskStatus = "Doing";
                    break;
                default:
                    taskStatus = "Unknown";
            }

            Addingtaskfeature[i] = new Task(taskName, taskDescription, firstName, lastName, duration, taskID, taskStatus);
        }

        System.out.println("\nTasks entered:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    // Generate Task ID
    private static String generateTaskID(String taskName, int taskNumber, String lastName) {
        String prefix = taskName.substring(0, 2).toUpperCase();
        String suffix = lastName.substring(Math.max(0, lastName.length() - 3)).toUpperCase();
        return prefix + ":" + taskNumber + ":" + suffix;
    }
}

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String firstName;
    private String lastName;
    private double duration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String firstName, String lastName, double duration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = duration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.taskNumber = TaskNumberGenerator.getNextTaskNumber();
    }

    @Override
    public String toString() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + firstName + " " + lastName +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nDuration: " + duration + " hours\n";
    }
}

class TaskNumberGenerator {
    private static int nextTaskNumber = 0;

    public static int getNextTaskNumber() {
        return nextTaskNumber++;
    }
}


    




       
