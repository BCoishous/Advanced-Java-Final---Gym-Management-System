package com.gym.service;

import com.gym.dao.WorkoutClassDAO;
import com.gym.model.WorkoutClass;
import java.util.List;


public class WorkoutClassService {
    
    private final WorkoutClassDAO workoutClassDAO;

    // Constructor
    public WorkoutClassService() {
        this.workoutClassDAO = new WorkoutClassDAO();
    }

    // Service methods that call DAO methods
    public boolean addWorkoutClass(WorkoutClass wc) {
        return workoutClassDAO.addWorkoutClass(wc);
    }

    // Service method to update workout class
    public boolean updateWorkoutClass(WorkoutClass wc) {
        return workoutClassDAO.updateWorkoutClass(wc);
    }

    // Service method to delete workout class
    public boolean deleteWorkoutClass(int id) {
        return workoutClassDAO.deleteWorkoutClass(id);
    }

    // Service method to get all workout classes
    public List<WorkoutClass> getAllWorkoutClasses() {
        return workoutClassDAO.getAllWorkoutClasses();
    }

    // Service method to get a workout class by ID
    public WorkoutClass getWorkoutClassById(int id) {
        return workoutClassDAO.getWorkoutClassById(id);
    }
}
