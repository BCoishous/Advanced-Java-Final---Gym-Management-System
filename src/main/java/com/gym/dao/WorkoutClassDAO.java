package com.gym.dao;

import com.gym.model.WorkoutClass;
import com.gym.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutClassDAO {

    public boolean addWorkoutClass(WorkoutClass wc) {
        String sql = "INSERT INTO workout_classes (name, trainer_name, day_of_week, time_slot, capacity) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);

            stmt.setString(1, wc.getName());
            stmt.setString(2, wc.getTrainerName());
            stmt.setString(3, wc.getDayOfWeek());
            stmt.setString(4, wc.getTimeSlot());
            stmt.setInt(5, wc.getCapacity());

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding workout class: " + e.getMessage());
            return false;
        }
    }

    public boolean updateWorkoutClass(WorkoutClass wc) {
        String sql = "UPDATE workout_classes SET name = ?, trainer_name = ?, day_of_week = ?, time_slot = ?, capacity = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);

            stmt.setString(1, wc.getName());
            stmt.setString(2, wc.getTrainerName());
            stmt.setString(3, wc.getDayOfWeek());
            stmt.setString(4, wc.getTimeSlot());
            stmt.setInt(5, wc.getCapacity());
            stmt.setInt(6, wc.getId());

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error updating workout class: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteWorkoutClass(int id) {
        String sql = "DELETE FROM workout_classes WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting workout class: " + e.getMessage());
            return false;
        }
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        List<WorkoutClass> list = new ArrayList<>();
        String sql = "SELECT * FROM workout_classes";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                WorkoutClass wc = new WorkoutClass(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("trainer_name"),
                        rs.getString("day_of_week"),
                        rs.getString("time_slot"),
                        rs.getInt("capacity")
                );
                list.add(wc);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error fetching workout classes: " + e.getMessage());
        }

        return list;
    }

    public WorkoutClass getWorkoutClassById(int id) {
        String sql = "SELECT * FROM workout_classes WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                WorkoutClass wc = new WorkoutClass(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("trainer_name"),
                        rs.getString("day_of_week"),
                        rs.getString("time_slot"),
                        rs.getInt("capacity")
                );

                rs.close();
                stmt.close();
                return wc;
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error fetching workout class by ID: " + e.getMessage());
        }

        return null;
    }
}