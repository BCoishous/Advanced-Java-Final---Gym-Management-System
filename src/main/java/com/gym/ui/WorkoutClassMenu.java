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
        System.out.print("Class name: ");
        String name = scanner.nextLine();
        System.out.print("Trainer name: ");
        String trainer = scanner.nextLine();
        System.out.print("Day of week: ");
        String day = scanner.nextLine();
        System.out.print("Time slot (e.g. 18:00-19:00): ");
        String time = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        WorkoutClass wc = new WorkoutClass(name, trainer, day, time, capacity);
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

        System.out.print("New name (" + existing.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) existing.setName(name);

        System.out.print("New trainer (" + existing.getTrainerName() + "): ");
        String trainer = scanner.nextLine();
        if (!trainer.isBlank()) existing.setTrainerName(trainer);

        System.out.print("New day (" + existing.getDayOfWeek() + "): ");
        String day = scanner.nextLine();
        if (!day.isBlank()) existing.setDayOfWeek(day);

        System.out.print("New time (" + existing.getTimeSlot() + "): ");
        String time = scanner.nextLine();
        if (!time.isBlank()) existing.setTimeSlot(time);

        System.out.print("New capacity (" + existing.getCapacity() + "): ");
        String cap = scanner.nextLine();
        if (!cap.isBlank()) existing.setCapacity(Integer.parseInt(cap));

        if (workoutClassService.updateWorkoutClass(existing)) {
            System.out.println("Workout class updated successfully!");
        } else {
            System.out.println("Failed to update workout class.");
        }
    }

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
