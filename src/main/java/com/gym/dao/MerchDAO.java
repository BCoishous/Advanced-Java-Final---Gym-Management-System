package com.gym.dao;

import com.gym.model.GymMerch;
import com.gym.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MerchDAO {
    // CRUD operations for GymMerch
    public boolean addMerch(GymMerch merch) {
        String sql = "INSERT INTO gym_merch (merch_id, merch_name, merch_type, merch_price, quantity_in_stock) VALUES (?, ?, ?, ?, ?)";


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, merch.getId());
            stmt.setString(2, merch.getName());
            stmt.setString(3, merch.getType());
            stmt.setDouble(4, merch.getPrice());
            stmt.setInt(5, merch.getStock());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding merch: " + e.getMessage());
            return false;
        }
    }

    // update prices for merch
    public boolean updatePrice(int merch_id, double newPrice) {
        String sql = "UPDATE gym_merch SET price = ? WHERE merch_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, merch_id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating price: " + e.getMessage());
            return false;
        }
    }

    // update stock for merch
    public boolean updateStock(int merch_id, int newStock) {
        String sql = "UPDATE gym_merch SET stock = ? WHERE merch_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newStock);
            stmt.setInt(2, merch_id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating stock: " + e.getMessage());
            return false;
        }
    }

    // list merch items
    public List<GymMerch> getAllMerch() {
        List<GymMerch> merchList = new ArrayList<>();
        String sql = "SELECT * FROM gym_merch";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                merchList.add(new GymMerch(
                                rs.getInt("merch_id"),
                                rs.getString("merch_name"),
                                rs.getString("merch_type"),
                                rs.getDouble("merch_price"),
                                rs.getInt("quantity_in_stock")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching merch: " + e.getMessage());
        }

        return merchList;
    }

    // calculate total stock value
    public double getTotalStockValue() {
        String sql = "SELECT SUM(price * stock) AS total_value FROM gym_merch";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getDouble("total_value");
            }

        } catch (SQLException e) {
            System.out.println("Error calculating stock value: " + e.getMessage());
        }

        return 0.0;
    }
}