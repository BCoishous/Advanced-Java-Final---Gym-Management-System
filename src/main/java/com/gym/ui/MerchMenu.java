package com.gym.ui;

import com.gym.model.GymMerch;
import com.gym.service.MerchService;

import java.util.List;
import java.util.Scanner;

public class MerchMenu {

    private final Scanner scanner;
    private final MerchService merchService;

    // Constructor
    public MerchMenu(Scanner scanner) {
        this.scanner = scanner;
        this.merchService = new MerchService();
    }

    // admin menu 
    public void displayForAdmin() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Gym Merchandise Management =====");
            System.out.println("1. Add merchandise");
            System.out.println("2. Update price");
            System.out.println("3. Update stock");
            System.out.println("4. View all merchandise");
            System.out.println("5. View total stock value");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> addMerch();
                case "2" -> updatePrice();
                case "3" -> updateStock();
                case "4" -> viewMerch();
                case "5" -> viewTotalStockValue();
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // member/trainer menu
    public void displayForMemberOrTrainer() {
        System.out.println("\n===== Available Merchandise =====");
        viewMerch();
    }

    // admin functions
    // add new merch item
    private void addMerch() {
        System.out.print("Item name: ");
        String name = scanner.nextLine();

        System.out.print("Item type: ");
        String type = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        GymMerch merch = new GymMerch(name, type, price, stock);

        if (merchService.addMerch(merch)) {
            System.out.println("Merchandise added successfully!");
        } else {
            System.out.println("Failed to add merchandise.");
        }
    }

    // update price for merch item
    private void updatePrice() {
        System.out.print("Enter item ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New price: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (merchService.updatePrice(id, price)) {
            System.out.println("Price updated.");
        } else {
            System.out.println("Failed to update price.");
        }
    }

    // update stock for merch item
    private void updateStock() {
        System.out.print("Enter item ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        if (merchService.updateStock(id, stock)) {
            System.out.println("Stock updated.");
        } else {
            System.out.println("Failed to update stock.");
        }
    }

    // view all merch items
    private void viewMerch() {
        List<GymMerch> merchList = merchService.getAllMerch();

        if (merchList.isEmpty()) {
            System.out.println("No merchandise found.");
            return;
        }

        for (GymMerch merch : merchList) {
            System.out.println(merch);
        }
    }

    // calculate total stock value
    private void viewTotalStockValue() {
        double total = merchService.getTotalStockValue();
        System.out.println("Total stock value: $" + total);
    }
}