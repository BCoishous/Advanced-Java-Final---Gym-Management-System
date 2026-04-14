package com.gym.ui;

import com.gym.model.Member;
import java.util.Scanner;

public class MemberMenu {

    private Scanner scanner;
    private Member member;
    private MembershipMenu membershipMenu;

    public MemberMenu(Scanner scanner, Member member, MembershipMenu membershipMenu) {
        this.scanner = scanner;
        this.member = member;
        this.membershipMenu = membershipMenu;
    }

    public void display() {
        boolean running = true;
        while (running) {
            member.displayMemberMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Browse classes coming soon!");
                    break;
                case "2":
                    membershipMenu.purchaseMembership();
                    break;
                case "3":
                    membershipMenu.viewMyMemberships();
                    break;
                case "4":
                    System.out.println("View merchandise coming soon!");
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