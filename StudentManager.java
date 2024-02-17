import java.util.ArrayList;
import java.util.Scanner;

// StudentManager.java
public class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.display();
        }
    }

    public void searchByPrn(String prn) {
        for (Student student : studentList) {
            if (student.getPrn().equals(prn)) {
                student.display();
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void updateMarksByPrn(String prn, double newMarks) {
        for (Student student : studentList) {
            if (student.getPrn().equals(prn)) {
                student.setMarks(newMarks);
                System.out.println("Marks updated successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Update Marks by PRN");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter PRN: ");
                    String prn = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character

                    Student newStudent = new Student(prn, name, dob, marks);
                    addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter PRN to search: ");
                    String searchPrn = scanner.nextLine();
                    searchByPrn(searchPrn);
                    break;

                case 4:
                    System.out.print("Enter PRN to update marks: ");
                    String updatePrn = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character

                    updateMarksByPrn(updatePrn, newMarks);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
