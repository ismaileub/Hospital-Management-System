package pharmacy;

import common.Common;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SellMedicine extends Common {

    private ArrayList<String> medicineList = new ArrayList<>();



    public void addAllDataToList() {
        medicineList.clear();
        try {
            File file = new File("medicine.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                medicineList.add(line.trim());
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }



    private void writeBackToFile() {
        try {
            File file = new File("medicine.txt");
            FileWriter writer = new FileWriter(file);

            for (String line : medicineList) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }



    private boolean updateStockByName(String medicineName, int stockChange, boolean isSell) {
        boolean medicineFound = false;


        for (int i = 0; i < medicineList.size(); i++) {
            String line = medicineList.get(i);

            // Parse medicine details
            String[] data = line.split(",");
            try {
                String name = data[0].split(":")[1].trim();
                double price = Double.parseDouble(data[1].split(":")[1].trim());
                int stock = Integer.parseInt(data[2].split(":")[1].trim());


                if (name.equalsIgnoreCase(medicineName)) {
                    medicineFound = true;

                    int updatedStock = stock + stockChange;



                    if (isSell && stockChange < 0) {
                        if (stock < -stockChange) {
                            System.out.println("Error: Insufficient stock to complete the operation!");
                            return false;
                        }
                        double totalPrice = (-stockChange) * price; // Calculate total price for selling
                        System.out.println("Total price: $" + totalPrice);
                    } else if (updatedStock < 0) {
                        System.out.println("Error: Stock cannot be negative!");
                        return false;
                    }

                    // Update the record in the list
                    medicineList.set(i, "Name: " + name + ", Price: " + price + ", Stock: " + updatedStock);

                    System.out.println("Stock updated successfully for medicine: " + name);
                    return true; // Exit after updating
                }

            } catch (Exception e) {
                System.out.println("Error parsing medicine data: " + e.getMessage());
            }
        }

        if (!medicineFound) {
            System.out.println("\nError: Medicine not found in the inventory.");
        }

        return false;
    }



    public void sellMedicine() {
        addAllDataToList(); // Load all medicines into the list

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter medicine name to sell: ");
        String medicineName = scanner.nextLine().trim();

        System.out.print("Enter quantity to sell: ");
        int quantityToSell;

        try {
            quantityToSell = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\nInvalid input for quantity! Please enter a valid number.");
            return;
        }


        boolean success = updateStockByName(medicineName, -quantityToSell, true);

        if (success) {
            System.out.println("Successfully purchased");
            writeBackToFile(); // Write changes to the file
        }
    }


    public void updateStock() {
        addAllDataToList(); // Load all medicines into the list

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter medicine name to update: ");
        String medicineName = scanner.nextLine().trim();

        System.out.print("Enter stock to add or set (positive or negative number): ");
        int stockChange;

        try {
            stockChange = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\nInvalid input for stock! Please enter a valid number.");
            return;
        }

        // Call the general update method to adjust stock
        boolean success = updateStockByName(medicineName, stockChange, false);

        if (success) {
            writeBackToFile(); // Write changes to the file
        }
    }


    public void sellAndUpdate(int option) {
        if (option == 1) {
            sellMedicine();
        } else if (option == 2) {
            updateStock();
        }
    }

    @Override
    public void details() {
        // Details implementation if required
    }
}
