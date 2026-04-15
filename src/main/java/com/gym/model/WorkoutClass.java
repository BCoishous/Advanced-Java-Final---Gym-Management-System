package com.gym.model;

public class WorkoutClass {
    // Fields
    private int id;
    private String name;
    private String trainerName;
    private String dayOfWeek;
    private String timeSlot; 
    private int capacity;

    public WorkoutClass() {}
    // constructor with all fields
    public WorkoutClass(int id, String name, String trainerName, String dayOfWeek, String timeSlot, int capacity) {
        this.id = id;
        this.name = name;
        this.trainerName = trainerName;
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
        this.capacity = capacity;
    }

    // Constructor wihtout id 
    public WorkoutClass(String name, String trainerName, String dayOfWeek, String timeSlot, int capacity) {
        this(0, name, trainerName, dayOfWeek, timeSlot, capacity);
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTrainerName() { return trainerName; }
    public void setTrainerName(String trainerName) { this.trainerName = trainerName; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // toString method for easy display
    @Override
    public String toString() {
        return "WorkoutClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}

