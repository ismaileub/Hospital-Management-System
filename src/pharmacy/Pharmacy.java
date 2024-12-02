package pharmacy;

import java.util.Scanner;

public class Pharmacy {


    public void display() {

//       System.out.println("Pharmacy's information");

        Scanner input = new Scanner(System.in);
        AddMedicine addMedicineObj = new AddMedicine();
        SellMedicine sellMedicine = new SellMedicine();
        //UpdateMedicine update = new UpdateMedicine();
        Medicine m = new Medicine();


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
                    addMedicineObj.details();
                    break;
                case 2:
                    m.displayInformation();
                    break;
                case 3:
                    sellMedicine.sellAndUpdate(1);
                    break;
                case 4:
                    sellMedicine.sellAndUpdate(2);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");

                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}

