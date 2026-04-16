package com.gym.ui;

import com.gym.model.Member;
import java.util.Scanner;

import com.gym.ui.WorkoutClassMenu;
import com.gym.ui.MembershipMenu;

public class MemberMenu {

    private Scanner scanner;
    private Member member;
    private MembershipMenu membershipMenu;
    private WorkoutClassMenu workoutClassMenu;
    private MerchMenu merchMenu;

    public MemberMenu(Scanner scanner, Member member, MembershipMenu membershipMenu , WorkoutClassMenu workoutClassMenu, MerchMenu merchMenu) {
        this.scanner = scanner;
        this.member = member;
        this.membershipMenu = membershipMenu;
        this.workoutClassMenu = workoutClassMenu;
        this.merchMenu = merchMenu;
    }

    public void display() {
        boolean running = true;
        while (running) {
            member.displayMemberMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    workoutClassMenu.viewClasses1();
                    break;
                case "2":
                    membershipMenu.purchaseMembership();
                    break;
                case "3":
                    membershipMenu.viewMyMemberships();
                    break;
                case "4":
                    merchMenu.displayForMemberOrTrainer();
                    break;
                case "5":
                    System.out.println("Logging out...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}