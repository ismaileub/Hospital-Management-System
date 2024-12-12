package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Common {

    public int id;
    public String name;
    public int age;
    public String gender;
    public String phone;

    public Common() {
    }

    public Common(int id, String name, int age, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Abstract method for specific details in subclasses
    public abstract void details();

    // Method to write data into a file
    public void writeDataInDatabase(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data + "\n");
            System.out.println("\nData added successfully: " + data);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data: " + e.getMessage());
        }
    }

    // Method to display only the data rows from a file
    public void displayDataRows(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isEmpty = true;

            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                String[] data = line.split(","); // Split the CSV data
                if (data.length >= 8) {
                    System.out.printf("%-5s %-20s %-5s %-10s %-15s %-25s %-15s %-20s\n",
                            data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                }
            }

            if (isEmpty) {
                System.out.println("No patients found in the system.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the data: " + e.getMessage());
        }
    }


    // Method to remove a patient by ID
    public void removeDataById(String patientId, String fileName) {
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder updatedData = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8 && data[0].equalsIgnoreCase(patientId)) {
                    found = true; // Skip the matching line
                } else {
                    updatedData.append(line).append("\n");
                }
            }

            if (found) {
                try (FileWriter writer = new FileWriter(fileName, false)) { // Overwrite the file
                    writer.write(updatedData.toString());
                    System.out.println("\nPatient with ID " + patientId + " has been removed successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while updating the file: " + e.getMessage());
                }
            } else {
                System.out.println("No patient found with ID: " + patientId);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

}
