# Student Management System (Java)

A simple console-based **Student Management System** developed using Java. This project allows users to manage student records, search and delete students, calculate statistics, sort students by grades, and store student information permanently using file handling.

## Features

- **Add Student** – Add new students with ID, name, and grade.
- **View All Students** – Display all registered student records.
- **Search Student** – Search for a student using their ID.
- **Delete Student** – Remove student records using their ID.
- **Show Statistics** – Display:
  - Total number of students.
  - Average student grade.
  - Top-performing student.
- **Sort by Grade** – Sort students from highest to lowest grade.
- **File Handling** – Save student records into a text file (`students.txt`).
- **Load Data** – Automatically load previously saved student records when the program starts.
- **Input Validation** – Validate user inputs to prevent invalid data.

## Technologies Used

- Java
- Java Collections Framework
- ArrayList
- Scanner Class
- File Handling (FileWriter, File)
- Exception Handling
- Lambda Expressions
- Sorting (Comparator)

## Project Structure

```text
Student-Management-System/
│
├── Main.java
├── Student.java
├── students.txt
└── README.md
```

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/Student-Management-System.git
```

### 2. Navigate to the Project Folder

```bash
cd Student-Management-System
```

### 3. Compile the Java Files

```bash
javac Main.java Student.java
```

### 4. Run the Program

```bash
java Main
```

## Application Menu

```text
*** STUDENT MANAGEMENT ***

1. Add Student
2. View All
3. Search Student
4. Delete Student
5. Show Stats
6. Sort by Grade
7. Exit

Choice:
```

## Data Storage

The application uses a text file named `students.txt` to store student information.

Each student record is stored in the following format:

```text
101,Kamal,85.5
102,Nimal,90.0
103,Amal,75.5
```

The application automatically loads saved records when it starts and updates the file when students are added or deleted.

## Learning Objectives

This project was developed to practice and improve Java programming skills, including:

- Object-Oriented Programming (OOP)
- ArrayList and Collections
- Loops and Conditional Statements
- Methods and Method Reusability
- Exception Handling
- File Input and Output
- Lambda Expressions
- Data Validation
- Basic Data Management

## Future Improvements

- Update Student Details
- Student Login System
- GUI using Java Swing or JavaFX
- Database Integration using MySQL
- Export Student Reports
- Password Authentication

## Author

**Gihan Madhubhasha**

Software Engineering Student | Java Developer

---

⭐ If you find this project useful, feel free to star the repository!
