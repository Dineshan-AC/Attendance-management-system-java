import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AttendanceManagementSystem {

    // Map to store student/employee names and their attendance
    private static Map<String, String> attendance = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to display the main menu
    public static void displayMenu() {
        System.out.println("----------- Attendance Management System -----------");
        System.out.println("1. Mark Attendance");
        System.out.println("2. View Attendance");
        System.out.println("3. Add New Student/Employee");
        System.out.println("4. Remove Attendance Record");
        System.out.println("5. Edit Attendance");
        System.out.println("6. Check Individual Attendance");
        System.out.println("7. Clear All Attendance Records");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to mark attendance
    public static void markAttendance() {
        System.out.print("Enter the name of the student/employee: ");
        String name = scanner.nextLine();
        System.out.print("Enter attendance (P for Present, A for Absent): ");
        String status = scanner.nextLine();

        // Check if status is valid
        if (status.equalsIgnoreCase("P") || status.equalsIgnoreCase("A")) {
            attendance.put(name, status);
            System.out.println("Attendance marked successfully.");
        } else {
            System.out.println("Invalid attendance status. Please enter 'P' for Present or 'A' for Absent.");
        }
    }

    // Method to view attendance
    public static void viewAttendance() {
        System.out.println("----------- Attendance Records -----------");
        if (attendance.isEmpty()) {
            System.out.println("No attendance records available.");
        } else {
            for (Map.Entry<String, String> entry : attendance.entrySet()) {
                System.out.println("Name: " + entry.getKey() + " | Status: " + entry.getValue());
            }
        }
    }

    // Method to add new student/employee to the system
    public static void addNewPerson() {
        System.out.print("Enter the name of the new student/employee: ");
        String name = scanner.nextLine();
        if (!attendance.containsKey(name)) {
            attendance.put(name, "Absent");  // Default status is Absent
            System.out.println("New student/employee added successfully.");
        } else {
            System.out.println("This person is already in the attendance system.");
        }
    }

    // Method to remove attendance record of a student/employee
    public static void removeAttendanceRecord() {
        System.out.print("Enter the name of the student/employee to remove: ");
        String name = scanner.nextLine();
        if (attendance.containsKey(name)) {
            attendance.remove(name);
            System.out.println("Attendance record removed successfully.");
        } else {
            System.out.println("No record found for " + name);
        }
    }

    // Method to edit attendance status of a student/employee
    public static void editAttendance() {
        System.out.print("Enter the name of the student/employee whose attendance you want to edit: ");
        String name = scanner.nextLine();
        if (attendance.containsKey(name)) {
            System.out.print("Enter the new attendance status (P for Present, A for Absent): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("P") || status.equalsIgnoreCase("A")) {
                attendance.put(name, status);
                System.out.println("Attendance updated successfully.");
            } else {
                System.out.println("Invalid attendance status. Please enter 'P' for Present or 'A' for Absent.");
            }
        } else {
            System.out.println("No record found for " + name);
        }
    }

    // Method to check the attendance status of an individual
    public static void checkIndividualAttendance() {
        System.out.print("Enter the name of the student/employee to check attendance: ");
        String name = scanner.nextLine();
        if (attendance.containsKey(name)) {
            System.out.println(name + " is " + attendance.get(name));
        } else {
            System.out.println("No attendance record found for " + name);
        }
    }

    // Method to clear all attendance records
    public static void clearAllRecords() {
        attendance.clear();
        System.out.println("All attendance records cleared.");
    }

    // Main method to run the program
    public static void main(String[] args) {
        int option;

        // Infinite loop for the menu until user chooses to exit
        while (true) {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (option) {
                case 1:
                    markAttendance();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    addNewPerson();
                    break;
                case 4:
                    removeAttendanceRecord();
                    break;
                case 5:
                    editAttendance();
                    break;
                case 6:
                    checkIndividualAttendance();
                    break;
                case 7:
                    clearAllRecords();
                    break;
                case 8:
                    System.out.println("Exiting the Attendance Management System. Goodbye!");
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
