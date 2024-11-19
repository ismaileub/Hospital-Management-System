package pharmacy;

import person.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SellMedicine extends Person {

    ArrayList<String> medicineList = new ArrayList<>();

    public boolean update = false;

    public void addAllDtaInList() {
        try {
            File file = new File("medicine.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                medicineList.add(line); // Add each line as it is to the list
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }


    private void writeBackToFile() {
        try {
            File file = new File("medicine.txt");
            java.io.FileWriter writer = new java.io.FileWriter(file);

            for (String line : medicineList) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public void update(boolean update) {
        this.update = update;

    }

    @Override
    public void details() {

        addAllDtaInList(); // Load all medicines into the list

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter medicine name to sell: ");
        String medicineName = scanner.nextLine();

        System.out.print("Enter quantity to sell: ");
        int quantityToSell = scanner.nextInt();

        boolean medicineFound = false;
        boolean stockSufficient = false;

        // Iterate through the medicine list to find and update the medicine
        for (int i = 0; i < medicineList.size(); i++) {
            String line = medicineList.get(i);

            // Extract fields using proper parsing
            String[] data = line.split(",");

            String name = data[0].split(":")[1].trim();  // Extract name after "Name:"

            double price = Double.parseDouble(data[1].split(":")[1].trim());  // Extract price after "Price:"

            int stock = Integer.parseInt(data[2].split(":")[1].trim());  // Extract stock after "Stock:"

            if (name.equalsIgnoreCase(medicineName)) {
                medicineFound = true;

                if (stock >= quantityToSell) {
                    stockSufficient = true;
                    double totalCost = quantityToSell * price;
                    stock -= quantityToSell; // Reduce stock

                    // Update the medicine record in the list
                    medicineList.set(i, "Name: " + name + ", Price: " + price + ", Stock: " + stock);

                    //System.out.println("Medicine sold successfully!");
                    System.out.println("Total price: " + totalCost);
                }
                break;
            }
        }

        if (!medicineFound) {
            System.out.println("Medicine not found!");
        } else if (!stockSufficient) {
            System.out.println("Insufficient stock!");
        }

        // Write the updated list back to the file
        writeBackToFile();
    }


}
