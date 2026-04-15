package com.gym.ui;

import com.gym.model.Admin;
import com.gym.model.Member;
import com.gym.model.Trainer;
import com.gym.model.User;
import com.gym.service.UserService;
import com.gym.util.GymLogger;
import com.gym.ui.MembershipMenu;
import com.gym.ui.TrainerMenu;
import com.gym.ui.MemberMenu;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();
    private GymLogger logger = GymLogger.getInstance();

    public void display() {
        System.out.println("=============================");
        System.out.println("  Welcome to the Gym System  ");
        System.out.println("=============================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    handleRegister();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    logger.info("Application exited");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleLogin() {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User user = userService.login(username, password);

        if (user != null) {
            System.out.println("\nWelcome back, " + user.getUsername() + "! Role: " + user.getRole());
            routeToMenu(user);
        }
    }

    private void handleRegister() {
        System.out.println("\n--- Register ---");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Address: ");
        String address = scanner.nextLine().trim();
        System.out.println("Role (ADMIN / TRAINER / MEMBER): ");
        String role = scanner.nextLine().trim().toUpperCase();

        boolean success = userService.register(username, password, email, phone, address, role);
        if (success) {
            System.out.println("Registration successful! Please log in.");
        }
    }

    private void routeToMenu(User user) {
        if (user instanceof Admin) {
            new AdminMenu(scanner, (Admin) user).display();
        } else if (user instanceof Trainer) {
            MembershipMenu membershipMenu = new MembershipMenu(scanner, user);
            WorkoutClassMenu workoutClassMenu = new WorkoutClassMenu(scanner);

            new TrainerMenu(scanner, (Trainer) user, membershipMenu, workoutClassMenu).display();
        } else if (user instanceof Member) {
            MembershipMenu membershipMenu = new MembershipMenu(scanner, user);
            new MemberMenu(scanner, (Member) user, membershipMenu).display();
        }
    }
}