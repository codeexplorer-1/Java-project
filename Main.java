// Main.java
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student\n2. View Students\n3. Edit Student\n4. Delete Student\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> editStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
        } else {
            students.forEach(System.out::println);
        }
    }

    static void editStudent() {
        System.out.print("Enter ID of student to edit: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new marks: ");
                s.setMarks(sc.nextInt());
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        String id = sc.nextLine();
        students.removeIf(s -> s.getId().equals(id));
        System.out.println("If student existed, they are now removed.");
    }
}
