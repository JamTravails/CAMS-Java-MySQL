# Continuous Assessment Management System (CAMS)

A role-based university Continuous Assessment Management System built with Java, JDBC, and MySQL. The system is designed to help manage student assessment records, lecturer activities, and user authentication.

## 🚀 Project Status

**In Progress**

The current version focuses on implementing the core authentication system and lecturer functionality. The project is being migrated to **Spring Boot** to introduce modern enterprise application development practices.

## 🛠 Technologies Used

- Java
- JDBC
- MySQL
- Object-Oriented Programming (OOP)
- DAO Design Pattern
- Spring Boot (Migration in Progress)


### 🔐 Authentication System
- User account creation
- Login functionality
- Role-based authentication using:
  - Lecturer account
  - Student account
  - Admin account (planned)
- LoginDAO implementation using JDBC PreparedStatements

### 👨‍🏫 Lecturer Module
- View lecturer profile
- Manage assigned courses
- View student records
- Enter continuous assessment marks
- Update continuous assessment marks

### 👨‍🎓 Student Module
- View student profile

## 🚧 Features Under Development

### Student Features
- Course registration
- View continuous assessment marks
- View academic results

### Lecturer Features
- Change password
- Logout functionality

### Admin Module
- User management
- System administration features

## 🏗 Project Structure
Continuous-Assessment-Management-System/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── cams/
│                   │
│                   ├── Main.java
│                   │
│                   ├── model/
│                   │   ├── Lecturer.java
│                   │   ├── Student.java
│                   │   ├── Course.java
│                   │   ├── Assessment.java
│                   │   └── Login.java
│                   │
│                   ├── dao/
│                   │   ├── DatabaseConnection.java
│                   │   ├── LoginDAO.java
│                   │   ├── LecturerDAO.java
│                   │   ├── StudentDAO.java
│                   │   ├── CourseDAO.java
│                   │   └── AssessmentDAO.java
│                   │
│                   ├── menu/
│                   │   ├── MainMenu.java
│                   │   ├── LecturerMenu.java
│                   │   ├── StudentMenu.java
│                   │   └── AdminMenu.java
│                   │
│                   └── service/
│                       ├── AuthenticationService.java
│                       └── AssessmentService.java
│
├── database/
│   └── cams_database.sql
│
├── README.md
├── .gitignore

## 🔑 Design Approach

The project follows the **DAO (Data Access Object) pattern** to separate database operations from application logic.

Benefits:
- Cleaner code structure
- Easier database management
- Better maintainability
- Improved scalability

## 📌 Future Improvements

- Complete migration to Spring Boot
- Implement REST APIs
- Add password encryption
- Implement role-based authorization
- Improve user interface
- Deploy as a web application

## 👨‍💻 Developer

**John Moyo**  
Software Engineering Student  
University of Zambia
