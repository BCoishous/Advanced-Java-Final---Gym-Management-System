package com.gym.model;

public class Member extends User {

    public Member(int userId, String username, String password, String email, String phoneNumber, String address) {
        super(userId, username, password, email, phoneNumber, address, "MEMBER");
    }

    public void displayMemberMenu() {
        System.out.println("\n=== MEMBER MENU ===");
        System.out.println("1. Browse workout classes");
        System.out.println("2. Purchase membership");
        System.out.println("3. View my membership expenses");
        System.out.println("4. View gym merchandise");
        System.out.println("5. Logout");
    }
}