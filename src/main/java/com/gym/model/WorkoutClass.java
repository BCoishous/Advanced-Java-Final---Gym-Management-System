package com.gym.model;

public class WorkoutClass {
    // Fields
    private int id;
    private String classType;
    private String description;
    private int trainerId;
    private String classDate;
    private String classTime;
    private int capacity;


    public WorkoutClass() {}
    // constructor with all fields
    public WorkoutClass(int id, String classType, String description, int trainerId, String classDate, String classTime, int capacity) {
        this.id = id;
        this.classType = classType;
        this.description = description;
        this.trainerId = trainerId;
        this.classDate = classDate;
        this.classTime = classTime;
        this.capacity = capacity;
    }

    // Constructor wihtout id 
    public WorkoutClass(String classType, String description, int trainerId, String classDate, String classTime, int capacity) {
        this(0, classType, description, trainerId, classDate, classTime, capacity);
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getTrainerId() { return trainerId; }
    public void setTrainerId(int trainerId) { this.trainerId = trainerId; }

    public String getClassDate() { return classDate; }
    public void setClassDate(String classDate) { this.classDate = classDate; }

    public String getClassTime() { return classTime; }
    public void setClassTime(String classTime) { this.classTime = classTime; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // toString method for easy display
    @Override
    public String toString() {
        return "WorkoutClass{" +
                "id=" + id +
                ", classType='" + classType + '\'' +
                ", description='" + description + '\'' +
                ", trainerId=" + trainerId +
                ", classDate='" + classDate + '\'' +
                ", classTime='" + classTime + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}

