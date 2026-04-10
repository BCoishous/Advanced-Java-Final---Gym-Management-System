-- Gym Management System Database Schema


-- Create tables
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    role VARCHAR(10) NOT NULL CHECK (role IN ('ADMIN', 'TRAINER', 'MEMBER'))
);

CREATE TABLE memberships (
    membership_id SERIAL PRIMARY KEY,
    membership_type VARCHAR(50) NOT NULL,
    membership_description VARCHAR(255),
    membership_cost NUMERIC(10, 2) NOT NULL,
    member_id INT NOT NULL,
    purchase_date DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (member_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE workout_classes (
    workout_class_id SERIAL PRIMARY KEY,
    class_type VARCHAR(50) NOT NULL,
    class_description VARCHAR(255),
    trainer_id INT NOT NULL,
    class_date DATE NOT NULL,
    class_time VARCHAR(20) NOT NULL,
    capacity INT NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE gym_merch (
    merch_id SERIAL PRIMARY KEY,
    merch_name VARCHAR(100) NOT NULL,
    merch_type VARCHAR(50) NOT NULL,
    merch_price NUMERIC(10, 2) NOT NULL,
    quantity_in_stock INT NOT NULL DEFAULT 0
);

-- Seed Data
INSERT INTO users (username, password, email, phone_number, address, role) VALUES
('admin1', '$2a$10$7EqJtq98hPqEX7fNZaFWoOa.sB9DFMJGaB6pMFqxqXvEMCLkxqhMK', 'admin@gym.com', '5061112222', '123 Admin St', 'ADMIN'),
('trainer1', '$2a$10$7EqJtq98hPqEX7fNZaFWoOa.sB9DFMJGaB6pMFqxqXvEMCLkxqhMK', 'trainer@gym.com', '5063334444', '456 Trainer Ave', 'TRAINER'),
('member1', '$2a$10$7EqJtq98hPqEX7fNZaFWoOa.sB9DFMJGaB6pMFqxqXvEMCLkxqhMK', 'member@gym.com', '5065556666', '789 Member Rd', 'MEMBER');

INSERT INTO memberships (membership_type, membership_description, membership_cost, member_id) VALUES
('Monthly', 'Full access for one month', 49.99, 3),
('Annual', 'Full access for one year', 499.99, 2);

INSERT INTO workout_classes (class_type, class_description, trainer_id, class_date, class_time, capacity) VALUES
('Yoga', 'Beginner friendly yoga class', 2, '2026-04-15', '09:00 AM', 20),
('HIIT', 'High intensity interval training', 2, '2026-04-16', '06:00 PM', 15);

INSERT INTO gym_merch (merch_name, merch_type, merch_price, quantity_in_stock) VALUES
('Protein Shake', 'Drink', 5.99, 50),
('Gym Gloves', 'Gear', 19.99, 30),
('Energy Bar', 'Food', 3.49, 100);