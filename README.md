# Simple CLI Complaint Management System

## Overview
This project is a **console-based complaint management system** written in Java.  
It provides menus for **Customers**, **Admins**, and **Support Staff** to handle complaint tickets. Complaints are stored in memory during runtime and can be managed through different roles.

## Features
### Customer Menu
- Create new complaint tickets
- Set complaint priority (LOW, MEDIUM, HIGH)
- Tickets are stored in a shared list

### Admin Menu
- Login with password (`1234`)
- View all complaints
- Search complaint by ID
- Close complaints
- Assign complaints to staff
- View complaints assigned to a staff member
- Return to main menu

### Support Staff Menu
- Login with staff name
- View assigned complaints
- Add comments to assigned complaints
- Close assigned complaints
- Return to main menu

### Complaint Class
- Stores complaint details: ID, description, priority, status, assigned staff, and staff comments
- Provides getter and setter methods for updating complaint information

## File Structure
- `Main.java` → Entry point, displays the main menu
- `CustomerMenu.java` → Handles customer ticket creation
- `AdminMenu.java` → Handles admin login and complaint management
- `SupportStaffMenu.java` → Handles support staff functionality
- `Complaints.java` → Complaint object model
