package com.gym.ui;

import com.gym.model.WorkoutClass;
import com.gym.service.WorkoutClassService;

import java.util.List;
import java.util.Scanner;

public class WorkoutClassMenu {

 private final Scanner scanner;
    private final WorkoutClassService workoutClassService;

    public WorkoutClassMenu(Scanner scanner) {
        this.scanner = scanner;
        this.workoutClassService = new WorkoutClassService();
    }

    // displays the menu for the workout classes
    public void display() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Workout Class Menu =====");
            System.out.println("1. View all classes");
            System.out.println("2. Add a class");
            System.out.println("3. Update a class");
            System.out.println("4. Delete a class");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> viewClasses1();
                case "2" -> addClass();
                case "3" -> updateClass();
                case "4" -> deleteClass();
                case "5" -> {
                    System.out.println("Returning to Trainer Menu...");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // displays the classes
    public void viewClasses1() {
        List<WorkoutClass> classes = workoutClassService.getAllWorkoutClasses();
        if (classes.isEmpty()) {
            System.out.println("No workout classes found.");
        } else {
            System.out.println("\n--- Available Workout Classes ---");
            for (WorkoutClass wc : classes) {
                System.out.println(wc);
            }
        }
    }

    // allows adding to the classes
    private void addClass() {
    System.out.print("Class Type: ");
    String classType = scanner.nextLine();

    System.out.print("Class Description: ");
    String description = scanner.nextLine();

    System.out.print("Trainer ID: ");
    int trainerId = Integer.parseInt(scanner.nextLine());

    System.out.print("Class Date (YYYY-MM-DD): ");
    String classDate = scanner.nextLine();

    System.out.print("Class Time (HH:MM): ");
    String classTime = scanner.nextLine();

    System.out.print("Capacity: ");
    int capacity = Integer.parseInt(scanner.nextLine());

    WorkoutClass wc = new WorkoutClass(classType, description, trainerId, classDate, classTime, capacity);

    if (workoutClassService.addWorkoutClass(wc)) {
        System.out.println("Workout class added successfully!");
    } else {
        System.out.println("Failed to add workout class.");
    }
}   

    // allows user to update the class
    private void updateClass() {
        System.out.print("Enter class ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        WorkoutClass existing = workoutClassService.getWorkoutClassById(id);

        if (existing == null) {
            System.out.println("Class not found.");
            return;
        }

        System.out.print("New class type (" + existing.getClassType() + "): ");
        String classType = scanner.nextLine();
        if (!classType.isBlank()) existing.setClassType(classType);

        System.out.print("New description (" + existing.getDescription() + "): ");
        String description = scanner.nextLine();
        if (!description.isBlank()) existing.setDescription(description);

        System.out.print("New trainer ID (" + existing.getTrainerId() + "): ");
        String trainerId = scanner.nextLine();
        if (!trainerId.isBlank()) existing.setTrainerId(Integer.parseInt(trainerId));

        System.out.print("New class date (" + existing.getClassDate() + ") [YYYY-MM-DD]: ");
        String classDate = scanner.nextLine();
        if (!classDate.isBlank()) existing.setClassDate(classDate);

        System.out.print("New class time (" + existing.getClassTime() + ") [HH:MM]: ");
        String classTime = scanner.nextLine();
        if (!classTime.isBlank()) existing.setClassTime(classTime);

        System.out.print("New capacity (" + existing.getCapacity() + "): ");
        String cap = scanner.nextLine();
        if (!cap.isBlank()) existing.setCapacity(Integer.parseInt(cap));

        if (workoutClassService.updateWorkoutClass(existing)) {
            System.out.println("Workout class updated successfully!");
        } else {
            System.out.println("Failed to update workout class.");
        }
    };

    // allows to delete the classes
    private void deleteClass() {
        System.out.print("Enter class ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

        if (workoutClassService.deleteWorkoutClass(id)) {
                System.out.println("Workout class deleted.");
        } else {
                System.out.println("Failed to delete workout class.");
        }
    }
}
