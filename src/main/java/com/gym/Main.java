package com.gym;

import com.gym.ui.MainMenu;
import com.gym.util.DBConnection;
import com.gym.util.GymLogger;

public class Main {
    public static void main(String[] args) {
        GymLogger logger = GymLogger.getInstance();
        logger.info("Application started");

        new MainMenu().display();

        DBConnection.closeConnection();
        logger.info("Application shutdown");
    }
}