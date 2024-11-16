package doctors;

import person.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Doctors extends Person {
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
            System.out.println("2. Display Doctors List");
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
        int choice;
        do {
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

            // Save the doctor data to the file
            try (FileWriter writer = new FileWriter("doctorsList.txt", true)) {
                writer.write(doctor.toString() + "\n");
                System.out.println("Doctor added successfully: " + doctor.toString());
            } catch (IOException e) {
                System.out.println("An error occurred while saving the doctor data: " + e.getMessage());
            }

            // Ask user if they want to add another doctor or return to the main menu
            System.out.println("\nPress 1 to add another doctor, or 0 to return to the main menu.");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (choice == 1);

        System.out.println("Returning to the main menu...");
    }

    // Method to format doctor details for file storage
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone: " + phone +
                ", Specialty: " + specialty + ", Qualification: " + qualification + ", Timing: " + timing + ", Room: " + roomNumber;
    }
}
