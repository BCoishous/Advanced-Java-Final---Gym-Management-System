package com.gym.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GymLogger {

    private static final Logger logger = Logger.getLogger("GymManagementSystem");
    private static GymLogger instance = null;
    private static FileHandler fileHandler;

    // Private constructor - Singleton pattern
    private GymLogger() {
        try {
            // Creates/appends to gym_log.txt in the project root
            fileHandler = new FileHandler("gym_log.txt", true);
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String timestamp = LocalDateTime.now().format(dtf);
                    return "[" + timestamp + "] " + record.getLevel() + ": " + record.getMessage() + "\n";
                }
            });
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Only write to file, not console
        } catch (IOException e) {
            System.out.println("Logger setup failed: " + e.getMessage());
        }
    }

    // Get the single instance of GymLogger
    public static GymLogger getInstance() {
        if (instance == null) {
            instance = new GymLogger();
        }
        return instance;
    }

    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    public void warning(String message) {
        logger.log(Level.WARNING, message);
    }

    public void severe(String message) {
        logger.log(Level.SEVERE, message);
    }
}