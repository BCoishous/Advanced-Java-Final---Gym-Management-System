package com.gym.service;

import com.gym.dao.UserDAO;
import com.gym.model.Admin;
import com.gym.model.Member;
import com.gym.model.Trainer;
import com.gym.model.User;
import com.gym.util.GymLogger;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private GymLogger logger = GymLogger.getInstance();

    // Register a new user with hashed password
    public boolean register(String username, String password, String email, String phoneNumber, String address, String role) {
        // Check if username already exists
        if (userDAO.getUserByUsername(username) != null) {
            System.out.println("Username already taken. Please choose another.");
            logger.warning("Registration failed - username already exists: " + username);
            return false;
        }

        // Hash the password before saving
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(0, username, hashedPassword, email, phoneNumber, address, role);
        boolean success = userDAO.registerUser(user);

        if (success) {
            logger.info("New user registered: " + username + " with role: " + role);
        } else {
            logger.severe("Registration failed for username: " + username);
        }
        return success;
    }

    // Login - returns the correct subclass based on role
    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            System.out.println("User not found.");
            logger.warning("Login failed - user not found: " + username);
            return null;
        }

        // Check the entered password against the hashed password
        if (!BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("Incorrect password.");
            logger.warning("Login failed - incorrect password for user: " + username);
            return null;
        }

        logger.info("User logged in: " + username + " with role: " + user.getRole());

        // Return the correct subclass based on role
        switch (user.getRole()) {
            case "ADMIN":
                return new Admin(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
            case "TRAINER":
                return new Trainer(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
            case "MEMBER":
                return new Member(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
            default:
                return user;
        }
    }

    // Get all users (Admin feature)
    public List<User> getAllUsers() {
        logger.info("Admin requested all users list");
        return userDAO.getAllUsers();
    }

    // Delete a user (Admin feature)
    public boolean deleteUser(int userId) {
        boolean success = userDAO.deleteUser(userId);
        if (success) {
            logger.info("User deleted with ID: " + userId);
        } else {
            logger.warning("Failed to delete user with ID: " + userId);
        }
        return success;
    }
}