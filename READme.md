# Gym Management System – Product & User Documentation

## 1. System Overview
The Gym Management System is a menu‑driven Java application designed to help gym owners and staff manage daily operations. It provides simple workflows for handling memberships, workout classes, and gym merchandise. All interactions happen through text‑based menus, so no technical knowledge is required.

The system supports three user roles:
- **Admin**
- **Trainer**
- **Member**

Each role has different responsibilities and access levels.

---

## 2. User Roles

### Admin
Admins manage the overall gym operations. They can:
- Add, update, and delete gym merchandise  
- View all merchandise  
- View all workout classes  
- Manage memberships  
- Access all system menus  

Admins have the highest level of control.

### Trainer
Trainers focus on workout classes. They can:
- Create new workout classes  
- View existing classes  
- Update or delete classes they manage  
- View merchandise (read‑only)  

Trainers cannot manage memberships or merchandise inventory.

### Member
Members interact with the gym as customers. They can:
- Purchase a membership  
- View available workout classes  
- View gym merchandise  

Members cannot modify any data.

---

## 3. Common Workflows

### A. Purchasing a Membership (Member)
1. Log in as a **Member**  
2. Select **Membership Options**  
3. Choose a membership type  
4. Confirm the purchase  
5. The system stores the membership and returns you to the main menu  

### B. Creating a Workout Class (Trainer)
1. Log in as a **Trainer**  
2. Select **Manage Workout Classes**  
3. Choose **Create New Class**  
4. Enter class name, date/time, and capacity  
5. Receive confirmation that the class was created  

### C. Viewing Workout Classes (All Roles)
1. Log in as **Admin**, **Trainer**, or **Member**  
2. Select **View Workout Classes**  
3. The system displays all classes with:  
   - Class name  
   - Trainer  
   - Date/time  
   - Capacity  

### D. Managing Gym Merchandise (Admin)
1. Log in as **Admin**  
2. Select **Manage Merchandise**  
3. Choose one of the following:  
   - Add merchandise  
   - Update merchandise  
   - Delete merchandise  
   - View all merchandise  
4. Follow the prompts to enter item details  

---

## 4. System Limitations
This version of the system includes simplified features:
- No graphical interface (terminal only)  
- Basic login system (no password encryption)  
- No online payments (membership purchases are simulated)  
- Members cannot register for classes (view‑only)  
- No attendance tracking  
- No low‑stock alerts for merchandise  
- Not designed for simultaneous multi‑user access  

These limitations keep the project focused on core functionality.

---