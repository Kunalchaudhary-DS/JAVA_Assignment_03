import java.util.*;

class InvalidMarksException extends Exception
{
    public InvalidMarksException(String msg) {
        super(msg);
    }
}

class Student {
    int roll;
    String name;
    int[] marks = new int[3];

    public Student(int roll, String name, int[] marks) throws InvalidMarksException {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        validate();
    }

    void validate() throws InvalidMarksException
    {
        for (int i = 0; i < 3; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " +(i + 1) + ": "+marks[i]);
            }
        }
    }

    double avg() {
        return (marks[0]+marks[1] +marks[2])/3.0;
    }

    void show() {
        System.out.println("Roll Number: " +roll);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks[0] +" " + marks[1]+ " " + marks[2]);
        System.out.println("Average: " + avg());
        System.out.println("Result: "+ (avg() >= 40 ?"Pass" : "Fail"));
    }
}

class ResultManager {
    Student[] list = new Student[100];
    int size = 0;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ResultManager rm = new ResultManager();
        try {
            rm.menu();
        } finally {
            rm.sc.close();
            System.out.println("Program terminated.");
        }
    }

    void menu() {
        while (true) {
            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    addStudent();
                    break;

                case "2":
                    showDetails();
                    break;

                case "3":
                    System.out.println("Exiting program. Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(sc.nextLine());
            }

            list[size++] = new Student(roll, name, marks);
            System.out.println("Student added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void showDetails() {
        System.out.print("Enter Roll Number to search: ");
        int roll;

        try {
            roll = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid roll number.");
            return;
        }

        for(int i = 0; i<size;i++) {
            if (list[i].roll == roll) {
                list[i].show();
                System.out.println("Search completed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}



