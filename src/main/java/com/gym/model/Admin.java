package com.gym.model;

public class Admin extends User {

    public Admin(int userId, String username, String password, String email, String phoneNumber, String address) {
        super(userId, username, password, email, phoneNumber, address, "ADMIN");
    }

    public void displayAdminMenu() {
        System.out.println("\n=== ADMIN MENU ===");
        System.out.println("1. View all users");
        System.out.println("2. Delete a user");
        System.out.println("3. View all memberships");
        System.out.println("4. View all merchandise");
        System.out.println("5. View total revenue");
        System.out.println("6. Logout");
    }
}