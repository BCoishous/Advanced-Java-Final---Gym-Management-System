package com.gym.model;

public class Trainer extends User {

    public Trainer(int userId, String username, String password, String email, String phoneNumber, String address) {
        super(userId, username, password, email, phoneNumber, address, "TRAINER");
    }

    public void displayTrainerMenu() {
        System.out.println("\n=== TRAINER MENU ===");
        System.out.println("1. View my classes");
        System.out.println("2. Purchase membership");
        System.out.println("3. View gym merchandise");
        System.out.println("4. Logout");
    }
}