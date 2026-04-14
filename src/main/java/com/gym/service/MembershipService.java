package com.gym.service;

import com.gym.dao.MembershipDAO;
import com.gym.model.Membership;
import com.gym.util.GymLogger;

import java.time.LocalDate;
import java.util.List;

public class MembershipService {

    private MembershipDAO membershipDAO = new MembershipDAO();
    private GymLogger logger = GymLogger.getInstance();

    // Purchase a membership
    public boolean purchaseMembership(int userId, String type, String description, double cost) {
        Membership membership = new Membership(0, type, description, cost, userId, LocalDate.now());
        boolean success = membershipDAO.addMembership(membership);
        if (success) {
            logger.info("Membership purchased - type: " + type + " by userId: " + userId);
        } else {
            logger.warning("Membership purchase failed for userId: " + userId);
        }
        return success;
    }

    // Get memberships for a specific user
    public List<Membership> getMembershipsByUserId(int userId) {
        logger.info("Fetching memberships for userId: " + userId);
        return membershipDAO.getMembershipsByUserId(userId);
    }

    // Get all memberships (Admin)
    public List<Membership> getAllMemberships() {
        logger.info("Admin requested all memberships");
        return membershipDAO.getAllMemberships();
    }

    // Get total revenue (Admin)
    public double getTotalRevenue() {
        logger.info("Admin requested total revenue");
        return membershipDAO.getTotalRevenue();
    }
}