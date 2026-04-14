package com.gym.ui;

import com.gym.model.Trainer;
import java.util.Scanner;

public class TrainerMenu {

    private Scanner scanner;
    private Trainer trainer;
    private MembershipMenu membershipMenu;

    public TrainerMenu(Scanner scanner, Trainer trainer, MembershipMenu membershipMenu) {
        this.scanner = scanner;
        this.trainer = trainer;
        this.membershipMenu = membershipMenu;
    }

    public void display() {
        boolean running = true;
        while (running) {
            trainer.displayTrainerMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("View classes coming soon!");
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