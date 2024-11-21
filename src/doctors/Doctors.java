package doctors;

import common.Common;
import java.util.Scanner;

public class Doctors extends Common {

    private String specialty;
    private String qualification;
    private String timing;
    private int roomNumber;

    public Doctors(int id, String name, int age, String gender, String phone, String specialty, String qualification, String timing, int roomNumber) {
        super(id, name, age, gender, phone);
        this.specialty = specialty;
        this.qualification = qualification;
        this.timing = timing;
        this.roomNumber = roomNumber;
    }

    // Default constructor
    public Doctors() {

    }

    // Method to display the Doctors section menu and perform actions based on user input
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
                    displayInformation("doctorsList.txt");
                    break;
                case 0:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 0.");
                    break;
            }
        } while (option != 0); // Continue until the user chooses to return to the main menu
    }

    // Method to add a doctor by capturing user data and saving it to a file
    private void addDoctor(Scanner scanner) {
        int option;

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("                      **ADD DOCTOR**                                            ");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.print("Doctor's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Doctor's name: ");
        String name = scanner.nextLine();

        System.out.print("Doctor's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Doctor's gender: ");
        String gender = scanner.nextLine();

        System.out.print("Doctor's phone: ");
        String phone = scanner.nextLine();

        System.out.print("Doctor's specialty: ");
        String specialty = scanner.nextLine();

        System.out.print("Doctor's qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("Doctor's timing: ");
        String timing = scanner.nextLine();

        System.out.print("Doctor's room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        // Create a new Doctors object
        Doctors doctor = new Doctors(id, name, age, gender, phone, specialty, qualification, timing, roomNumber);

        String data = doctor.toString();
        String fileName = "doctorsList.txt";
        writeDataInDatabase(data, fileName);

        // details();
        return;

    }

    // Method to format doctor details for file storage
    @Override
    public String toString() {
        System.out.println("toString method called");
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone: " + phone
                + ", Specialty: " + specialty + ", Qualification: " + qualification + ", Timing: " + timing + ", Room: " + roomNumber;
    }
}
