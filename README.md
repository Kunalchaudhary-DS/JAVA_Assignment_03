# Student Result Management System (Java)

A simple Java console-based application that manages student results using exception handling, custom exceptions, and arrays. The program collects student details, validates marks, calculates averages, and displays results through a clean menu-driven interface.

---

##  Features
- Add students with roll number, name, and 3 subject marks  
- Validate marks (0–100) using a custom checked exception  
- Search and display any student by roll number  
- Calculate average marks and pass/fail status  
- Handles:
  - Invalid marks  
  - Wrong input format  
  - Missing data  
  - Number format errors  
- Demonstrates:
  - `try-catch`  
  - `throw` & `throws`  
  - `finally`  
  - Custom exceptions  
  - Arrays to store multiple students  

---

## Project Structure
All classes are combined in one file:

ResultManager.java
├── InvalidMarksException
├── Student
└── ResultManager (main class)

---

##  How to Run
1. Save the file as: Student_result_manager.java
2. Compile the program.
3. Run the program.

---
## Sample Output
===== Student Result Management System =====

Add Student

Show Student Details

Exit
Enter your choice: 1
Enter Roll Number: 101
Enter Student Name: Alice
Enter marks for subject 1: 85
Enter marks for subject 2: 92
Enter marks for subject 3: 88
Student added successfully.

If invalid marks are entered:
Error: Invalid marks for subject 1: -10


---

## ⚙️ Concepts Demonstrated
- Custom checked exception (`InvalidMarksException`)
- Throwing and handling exceptions  
- finally block for cleanup  
- Input validation  
- Arrays for storing objects  
- Clean and modular class structure  

