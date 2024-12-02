package patients;


import java.util.Scanner;

public class Patients{

    private final String fileName = "patients.txt";


    public void display() {
        Scanner input = new Scanner(System.in);
        AddPatient add = new AddPatient();

        while (true) {
            System.out.println("\n=== Patients Section ===");
            System.out.println("1. Add New Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    add.details();
                    break;
                case 2:
                    add.displayAllPatients();
                    break;
                case 3:
                    add.search();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

}

}
