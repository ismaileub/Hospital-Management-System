package doctors;

import common.Common;
import java.util.Scanner;

public class Doctors extends Common {

    private String specialty;
    private String qualification;
    private String timing;
    private int roomNumber;

    public Doctors(int id, String name, int age, String gender, String phone, String qualification, String timing, int roomNumber) {
        super(id, name, age, gender, phone);
        this.qualification = qualification;
        this.timing = timing;
        this.roomNumber = roomNumber;
    }

    // Default constructor
    public Doctors() {
    }

    @Override
    public void details() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("                      **DOCTOR SECTION**                                        ");
            System.out.println("--------------------------------------------------------------------------------");

            System.out.println("1. Add Doctor");
            System.out.println("2. Display Doctors Information");
            System.out.println("0. Return to Main Menu");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    displayDoctors();
                    break;
                case 0:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 0.");
                    break;
            }
        } while (option != 0);
    }

    // Display doctor data (header + rows)
    private void displayDoctors() {
        System.out.println("\n----------------------------------------- Doctor List ----------------------------------------------------");
        System.out.printf("%-7s %-19s %-5s %-10s %-15s %-26s %-12s %-20s\n",
                "ID", "Name", "Age", "Gender", "Phone", "Qualification", "Timing", "Room No.");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        displayDataRows("doctorsList.txt");
    }

    private void addDoctor(Scanner scanner) {
        System.out.print("Doctor's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Doctor's name: ");
         name = scanner.nextLine();

        System.out.print("Doctor's age: ");
         age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Doctor's gender: ");
         gender = scanner.nextLine();

        System.out.print("Doctor's phone: ");
         phone = scanner.nextLine();

        System.out.print("Doctor's qualification: ");
         qualification = scanner.nextLine();

        System.out.print("Doctor's timing: ");
         timing = scanner.nextLine();

        System.out.print("Doctor's room number: ");
         roomNumber = scanner.nextInt();
        scanner.nextLine();

        Doctors doctor = new Doctors(id, name, age, gender, phone, qualification, timing, roomNumber);
        String data = id + "," + name + "," + age + "," + gender + "," + phone + "," + qualification + "," + timing + "," + roomNumber;

        writeDataInDatabase(data, "doctorsList.txt");
    }
}
