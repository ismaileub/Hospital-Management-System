package pharmacy;

import java.util.Scanner;

public class Pharmacy {


    public void display() {

//       System.out.println("Pharmacy's information");

        Scanner input = new Scanner(System.in);
        AddMedicine addMedicineObj = new AddMedicine();
        SellMedicine sell = new SellMedicine();
        boolean stockUpdate = true;


        while (true) {
            System.out.println("\n=== Pharmacy Section ===");
            System.out.println("1. Add Medicine");
            System.out.println("2. Available Medicine");
            System.out.println("3. Sell Medicine");
            System.out.println("4. Update Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addMedicineObj.takeInfo(input);
                    break;
                case 2:
                    addMedicineObj.displayInformation("medicine.txt");
                    break;
                case 3:
                    sell.details();
                    break;
                case 4:
                    sell.update(stockUpdate);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}

