import patients.Patients;
import pharmacy.Pharmacy;
import facilities.Facilities;
import doctors.Doctors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            // Display Date and Time
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("MMM d yyyy");
            String currentDate = dateFormat.format(date);

            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String formattedTime = time.format(formatter);

            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("      *** Welcome to Hospital and Health Care Management System  ***");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("       Date: " + currentDate + "                            " + "Time: " + formattedTime);

            // Display Main Menu
            System.out.println("\n                                 MAIN MENU");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("1. Doctors Section\n2. Patients Section\n3. Pharmacy Section\n4. Hospital Facilities\n5. Exit");
            System.out.println("-----------------------------------------------------------------------------------");

            System.out.print("Enter your option: ");
            int option = input.nextInt();
            input.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    Doctors doctors = new Doctors();
                    doctors.details();
                    break;

                case 2:
                    Patients patients = new Patients();
                    patients.display();
                    break;

                case 3:
                    Pharmacy pharmacy = new Pharmacy();
                    pharmacy.display();
                    break;

                case 4:
                    Facilities facilities = new Facilities();
                    facilities.facilities();
                    break;

                case 5:
                    System.out.println("Exiting the system... Goodbye!");
                    input.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid option. Please select a valid option from (1, 2, 3, 4, or 5).");
            }
        }
    }
}
