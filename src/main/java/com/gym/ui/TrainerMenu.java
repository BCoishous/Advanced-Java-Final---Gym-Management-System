package com.gym.ui;

import com.gym.model.Trainer;
import java.util.Scanner;

public class TrainerMenu {

    private Scanner scanner;
    private Trainer trainer;
    private MembershipMenu membershipMenu;
    private WorkoutClassMenu workoutClassMenu;

    public TrainerMenu(Scanner scanner, Trainer trainer, MembershipMenu membershipMenu, WorkoutClassMenu workoutClassMenu) {
        this.scanner = scanner;
        this.trainer = trainer;
        this.membershipMenu = membershipMenu;
        this.workoutClassMenu = workoutClassMenu;
    }

    public void display() {
        boolean running = true;
        while (running) {
            trainer.displayTrainerMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    workoutClassMenu.display();
                    break;
                case "2":
                    membershipMenu.purchaseMembership();
                    break;
                case "3":
                    System.out.println("View merchandise coming soon!");
                    break;
                case "4":
                    System.out.println("Logging out...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}