package com.gym.dao;

import com.gym.model.Membership;
import com.gym.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAO {

    // Purchase a new membership
    public boolean addMembership(Membership membership) {
        String sql = "INSERT INTO memberships (membership_type, membership_description, membership_cost, member_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, membership.getMembershipType());
            stmt.setString(2, membership.getMembershipDescription());
            stmt.setDouble(3, membership.getMembershipCost());
            stmt.setInt(4, membership.getMemberId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding membership: " + e.getMessage());
            return false;
        }
    }

    // Get all memberships for a specific user
    public List<Membership> getMembershipsByUserId(int userId) {
        List<Membership> memberships = new ArrayList<>();
        String sql = "SELECT * FROM memberships WHERE member_id = ?";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                memberships.add(new Membership(
                    rs.getInt("membership_id"),
                    rs.getString("membership_type"),
                    rs.getString("membership_description"),
                    rs.getDouble("membership_cost"),
                    rs.getInt("member_id"),
                    rs.getDate("purchase_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching memberships: " + e.getMessage());
        }
        return memberships;
    }

    // Get all memberships (Admin feature)
    public List<Membership> getAllMemberships() {
        List<Membership> memberships = new ArrayList<>();
        String sql = "SELECT * FROM memberships";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                memberships.add(new Membership(
                    rs.getInt("membership_id"),
                    rs.getString("membership_type"),
                    rs.getString("membership_description"),
                    rs.getDouble("membership_cost"),
                    rs.getInt("member_id"),
                    rs.getDate("purchase_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all memberships: " + e.getMessage());
        }
        return memberships;
    }

    // Get total revenue (Admin feature)
    public double getTotalRevenue() {
        String sql = "SELECT SUM(membership_cost) FROM memberships";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Error calculating revenue: " + e.getMessage());
        }
        return 0.0;
    }
}