package com.gym.model;

public class GymMerch {
    // 
    private int id;
    private String name;
    private String type;
    private double price;
    private int stock;


    // Constructors 
    public GymMerch(String name, String type, double price, int stock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public GymMerch(int id, String name, String type, double price, int stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    // toString method for easy display
    @Override
    public String toString() {
        return 
        "Merch ID: " + id +
        " | Name: " + name +
        " | Type: " + type +
        " | Price: $" + price +
        " | Stock: " + stock;
    }
}