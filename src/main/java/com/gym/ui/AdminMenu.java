package com.gym.ui;

import com.gym.model.Admin;
import com.gym.model.Membership;
import com.gym.model.User;
import com.gym.service.MembershipService;
import com.gym.service.MerchService;
import com.gym.service.UserService;
import com.gym.util.GymLogger;


import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private Scanner scanner;
    private Admin admin;
    private UserService userService = new UserService();
    private MembershipService membershipService = new MembershipService();
    private GymLogger logger = GymLogger.getInstance();

    private MerchService merchService = new MerchService();
    private MerchMenu merchMenu;

    public AdminMenu(Scanner scanner, Admin admin) {
        this.scanner = scanner;
        this.admin = admin;
        this.merchMenu = new MerchMenu(merchService);
    }

    public void display() {
        boolean running = true;
        while (running) {
            admin.displayAdminMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    viewAllUsers();
                    break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    viewAllMemberships();
                    break;
                    case "4":
                    merchMenu.displayForAdmin();
                    break;
                case "5":
                    viewTotalRevenue();
                    break;
                case "6":
                    System.out.println("Logging out...");
                    logger.info("Admin logged out: " + admin.getUsername());
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewAllUsers() {
        System.out.println("\n--- All Users ---");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
                System.out.println("ID: " + user.getUserId()
                        + " | Username: " + user.getUsername()
                        + " | Email: " + user.getEmail()
                        + " | Phone: " + user.getPhoneNumber()
                        + " | Address: " + user.getAddress()
                        + " | Role: " + user.getRole());
            }
        }
    }

    private void deleteUser() {
        System.out.println("\n--- Delete User ---");
        viewAllUsers();
        System.out.print("Enter the ID of the user to delete: ");
        try {
            int userId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Are you sure? (yes/no): ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("yes")) {
                boolean success = userService.deleteUser(userId);
                if (success) {
                    System.out.println("User deleted successfully.");
                } else {
                    System.out.println("User not found.");
                }
            } else {
                System.out.println("Delete cancelled.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
            logger.warning("Admin entered invalid user ID for deletion");
        }
    }

    private void viewAllMemberships() {
        System.out.println("\n--- All Memberships ---");
        List<Membership> memberships = membershipService.getAllMemberships();
        if (memberships.isEmpty()) {
            System.out.println("No memberships found.");
        } else {
            for (Membership m : memberships) {
                System.out.println("ID: " + m.getMembershipId()
                        + " | Type: " + m.getMembershipType()
                        + " | Cost: $" + m.getMembershipCost()
                        + " | MemberID: " + m.getMemberId()
                        + " | Date: " + m.getPurchaseDate());
            }
        }
    }

    private void viewTotalRevenue() {
        double revenue = membershipService.getTotalRevenue();
        System.out.println("\n--- Total Revenue ---");
        System.out.printf("Total membership revenue: $%.2f%n", revenue);
        logger.info("Admin viewed total revenue: $" + revenue);
    }
}