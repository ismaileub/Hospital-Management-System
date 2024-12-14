package facilities;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Facilities {
    private boolean firstTime = true;
    String name;
    String cost;

    void banner(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                      **Hospitals Facilities**                                    ");
        System.out.println("----------------------------------------------------------------------------------");
    }


    public void facilities() {

        if (firstTime) {
            banner();
            firstTime = false;
        }

        Scanner input = null;
        try {
            input = new Scanner(System.in);
            System.out.println("1/Add New Facilities\n2/Check Facilities List\n");
            System.out.print("Enter Your Option (1, 2, or 0 to go back): ");

            int option = input.nextInt();
            input.nextLine(); // Consume newline character

            if (option == 1) {
                addNewFacility(input);
            } else if (option == 2) {
                checkFacilitiesList(input);
            } else if (option == 0) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid option.");
                facilities();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input. Please enter a valid integer.");
            input.next();
            facilities();
        }
    }

    private void addNewFacility(Scanner input) {
        try {
            System.out.println("Enter facility name and cost");
            System.out.print("Name: ");
            name = input.nextLine();

            System.out.print("Cost: ");
            cost = input.nextLine();

            // Append data to the file
            try (FileWriter writer = new FileWriter("facilitiesList.txt", true)) {
                writer.write(name + "        " + cost + "\r\n");
                writer.flush(); // Ensure data is written to the file
                System.out.println("Facility added successfully: " + name + " - $" + cost+"\n");
                facilities();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid name and cost.");
            input.nextLine(); // Clear invalid input
        }
    }





    private void checkFacilitiesList(Scanner input) {
        try {
            File file = new File("facilitiesList.txt");

            if (!file.exists()) {
                System.out.println("No facilities found. Add facilities first.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            System.out.println(String.format("%-3s %-30s %-10s", "No.", "Facility Name", "Cost"));
            System.out.println("------------------------------------------------");

            int i = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                i++;
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    String name = String.join(" ", Arrays.copyOfRange(parts, 0, parts.length - 1));
                    String cost = parts[parts.length - 1];
                    System.out.println(String.format("%-3d %-30s $%-10s", i, name, cost));
                }
            }
            reader.close();

            System.out.println("\nPress 1 to go back, or 0 to return to the main menu.");
            int option = input.nextInt();
            input.nextLine();  // Consume newline character
            if (option == 1) {
                facilities();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}
