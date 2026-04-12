package com.gym.service;

import com.gym.dao.UserDAO;
import com.gym.model.Admin;
import com.gym.model.Member;
import com.gym.model.Trainer;
import com.gym.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    // Register a new user with hashed password
    public boolean register(String username, String password, String email, String phoneNumber, String address, String role) {
        // Check if username already exists
        if (userDAO.getUserByUsername(username) != null) {
            System.out.println("Username already taken. Please choose another.");
            return false;
        }

        // Hash the password before saving
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(0, username, hashedPassword, email, phoneNumber, address, role);
        return userDAO.registerUser(user);
    }

    // Login - returns the correct subclass based on role
    public User login(String username, String password) {
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            System.out.println("User not found.");
            return null;
        }

        // Check the entered password against the hashed password
        if (!BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("Incorrect password.");
            return null;
        }

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
        return userDAO.getAllUsers();
    }

    // Delete a user (Admin feature)
    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
}