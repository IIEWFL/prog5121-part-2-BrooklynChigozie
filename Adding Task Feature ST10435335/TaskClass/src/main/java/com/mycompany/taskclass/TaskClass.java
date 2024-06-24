/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskclass;

/**
 *
 * @author brook
 */
public class TaskClass {
    private String taskName;
    private String taskDescription;
    private String firstName;
    private String lastName;
    private double duration;
    private String taskID;
    private String taskStatus;

    public TaskClass(String taskName, String taskDescription, String firstName, String lastName,
                double duration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = duration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    // Check if task description is not more than 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Creates and returns the task ID
    public String createTaskID() {
        String prefix = taskName.substring(0, 2).toUpperCase();
        String suffix = lastName.substring(Math.max(0, lastName.length() - 3)).toUpperCase();
        return prefix + ":" + taskID + ":" + suffix;
    }

    // Return full task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + firstName + " " + lastName +
                "\nTask Number: " + taskID +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nDuration: " + duration + " hours";
    }

    // Returns total combined hours of all tasks entered
    public static int returnTotalHours(TaskClass[] tasks) {
        int totalHours = 0;
        for (TaskClass task : tasks) {
            totalHours += task.duration;
        }
        return totalHours;
    }
}
