import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Facilities {

    String name;
    String cost;

    public void facilities() {
        Scanner input = new Scanner(System.in); // Initialize scanner
        int option;
        System.out.println("1/Add New Facilities\n2/Check Facilities List");
        System.out.print("Enter Your Option from 1 and 2: ");
        option = input.nextInt();
        input.nextLine();  // Consume the newline character after reading the integer

        if (option == 1) {

            while (true) {
                try {
                    System.out.println("Enter facility name and cost or '1' to quit");
                    System.out.print("Name: ");
                    name = input.nextLine();  // Use nextLine to read the full name

                    if (name.equals("1")) {
                        System.out.println("System quitting....");
                        break;
                    }

                    System.out.print("Cost: ");
                    cost = input.nextLine();  // Use nextLine to read the full cost input

                    // Write the facility data to the file
                    try (FileWriter writer = new FileWriter("D://Programming//JAVA//Hospital_Management_System//storage/facilitiesList.txt", true)) {

                        writer.write(name + "        " + cost + "\r\n"); // Writing facility data with a newline
                        System.out.println("Facility added successfully: " + name + " - $" + cost);

                    } catch (IOException e) {
                        System.out.println("An error occurred while writing to the data: " + e.getMessage());
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter valid name and cost.");
                }
            }

        } else if (option == 2) {
            // Option to check the facilities list


            try {

                File file = new File("D://Programming//JAVA//Hospital_Management_System//storage/facilitiesList.txt");


                BufferedReader reader = new BufferedReader(new FileReader(file));
                System.out.println(String.format("%-3s %-30s %-10s", "No.", "Facility Name", "Cost"));
                System.out.println("------------------------------------------------");

                int i = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    i++;
                    String[] parts = line.split("\\s+"); // Split by spaces for name and cost

                    if (parts.length >= 2) {

                        String name = String.join(" ", Arrays.copyOfRange(parts, 0, parts.length - 1));

                        String cost = parts[parts.length - 1];

                        // Using String.format to align columns
                        System.out.println(String.format("%-3d %-30s %-10s", i, name, cost));
                    }
                }
                reader.close();


            } catch (Exception e) {
                System.out.println("An error occurred while reading from the file: " + e.getMessage());
            }
        }

        input.close(); // Close scanner after the loop ends
    }
}
