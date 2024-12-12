package patients;

import common.Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AddPatient extends Common {

    private String address;
    private int roomNumber;
    private String assignedToDoctor;

    public AddPatient() {
    }

    public AddPatient(int id, String name, int age, String gender, String phone, String address, int roomNumber, String assignedToDoctor) {
        super(id, name, age, gender, phone);
        this.address = address;
        this.roomNumber = roomNumber;
        this.assignedToDoctor = assignedToDoctor;
    }

    @Override
    public void details() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Patient Name: ");
        name = input.nextLine();

        System.out.print("Enter Patient Age: ");
        age = input.nextInt();
        input.nextLine();

        System.out.print("Enter Patient Gender: ");
        gender = input.nextLine();

        System.out.print("Enter Patient Phone: ");
        phone = input.nextLine();

        System.out.print("Enter Patient Address: ");
        address = input.nextLine();

        System.out.print("Enter Room Number: ");
        roomNumber = input.nextInt();
        input.nextLine();

        System.out.print("Assigned Doctor's Name: ");
        assignedToDoctor = input.nextLine();

        String patientData = id + "," + name + "," + age + "," + gender + "," + phone + "," + address + "," + roomNumber + "," + assignedToDoctor;
        writeDataInDatabase(patientData, "patients.txt");
    }

    public void displayAllPatients() {
        System.out.println("\n------------------------------------------------ Patient List ----------------------------------------------------");
        System.out.printf("%-7s %-18s %-5s %-10s %-15s %-24s %-16s %-20s\n",
                "ID", "Name", "Age", "Gender", "Phone", "Address", "Room No.", "Assigned Doctor");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        displayDataRows("patients.txt");
    }

    // Search for patients by ID or Name
    public void search() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Search Patient ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Patient ID: ");
                String searchId = input.nextLine();
                searchPatientByIdOrName("patients.txt", searchId, true);
                break;

            case 2:
                System.out.print("Enter Patient Name: ");
                String searchName = input.nextLine();
                searchPatientByIdOrName("patients.txt", searchName, false);
                break;

            default:
                System.out.println("Invalid choice. Returning to menu...");
        }
    }

    // Common method to search by ID or Name
    private void searchPatientByIdOrName(String fileName, String searchValue, boolean searchById) {
        System.out.println("\n--- Search Results ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (searchById && data.length >= 8 && data[0].equalsIgnoreCase(searchValue)) {
                    found = true;
                    displayPatientDetails(data);
                    break; // ID is unique, no need to continue searching
                } else if (!searchById && data.length >= 8 && data[1].equalsIgnoreCase(searchValue)) {
                    found = true;
                    displayPatientDetails(data);
                }
            }

            if (!found) {
                System.out.println("No patient found with " + (searchById ? "ID: " : "Name: ") + searchValue);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while searching for the patient: " + e.getMessage());
        }
    }

    // Method to remove a patient by ID
    public void removePatient() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n--- Remove Patient ---");
        System.out.print("Enter Patient ID: ");
        String removeId = input.nextLine();

        
        removeDataById(removeId, "patients.txt");
    }



    // Display details of a single patient
    private void displayPatientDetails(String[] data) {
        System.out.println("\n--- Patient Details ---");
        System.out.println("ID: " + data[0]);
        System.out.println("Name: " + data[1]);
        System.out.println("Age: " + data[2]);
        System.out.println("Gender: " + data[3]);
        System.out.println("Phone: " + data[4]);
        System.out.println("Address: " + data[5]);
        System.out.println("Room Number: " + data[6]);
        System.out.println("Assigned Doctor: " + data[7]);
    }
}
