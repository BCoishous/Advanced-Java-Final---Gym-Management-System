package com.gym.ui;

import com.gym.model.Trainer;
import java.util.Scanner;



public class TrainerMenu {

    private Scanner scanner;
    private Trainer trainer;
    private MembershipMenu membershipMenu;
    private WorkoutClassMenu workoutClassMenu;
    private MerchMenu merchMenu;


    public TrainerMenu(Scanner scanner, Trainer trainer, MembershipMenu membershipMenu, WorkoutClassMenu workoutClassMenu, MerchMenu merchMenu) {
        this.scanner = scanner;
        this.trainer = trainer;
        this.membershipMenu = membershipMenu;
        this.workoutClassMenu = workoutClassMenu;
        this.merchMenu = merchMenu;
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
                    merchMenu.displayForMemberOrTrainer();
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