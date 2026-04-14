package com.gym.ui;

import com.gym.model.Membership;
import com.gym.model.User;
import com.gym.service.MembershipService;
import com.gym.util.GymLogger;

import java.util.List;
import java.util.Scanner;

public class MembershipMenu {

    private Scanner scanner;
    private User user;
    private MembershipService membershipService = new MembershipService();
    private GymLogger logger = GymLogger.getInstance();

    public MembershipMenu(Scanner scanner, User user) {
        this.scanner = scanner;
        this.user = user;
    }

    public void purchaseMembership() {
        System.out.println("\n--- Purchase Membership ---");
        System.out.println("Available Memberships:");
        System.out.println("1. Monthly - Full access for one month - $49.99");
        System.out.println("2. Annual  - Full access for one year  - $499.99");
        System.out.print("Choose an option: ");
        String input = scanner.nextLine().trim();

        String type, description;
        double cost;

        switch (input) {
            case "1":
                type = "Monthly";
                description = "Full access for one month";
                cost = 49.99;
                break;
            case "2":
                type = "Annual";
                description = "Full access for one year";
                cost = 499.99;
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        boolean success = membershipService.purchaseMembership(user.getUserId(), type, description, cost);
        if (success) {
            System.out.println("Membership purchased successfully! Type: " + type + " | Cost: $" + cost);
        } else {
            System.out.println("Failed to purchase membership. Please try again.");
        }
    }

    public void viewMyMemberships() {
        System.out.println("\n--- My Memberships ---");
        List<Membership> memberships = membershipService.getMembershipsByUserId(user.getUserId());
        if (memberships.isEmpty()) {
            System.out.println("You have no memberships.");
        } else {
            double total = 0;
            for (Membership m : memberships) {
                System.out.println("ID: " + m.getMembershipId()
                        + " | Type: " + m.getMembershipType()
                        + " | Cost: $" + m.getMembershipCost()
                        + " | Date: " + m.getPurchaseDate());
                total += m.getMembershipCost();
            }
            System.out.println("Total spent: $" + total);
        }
    }
}