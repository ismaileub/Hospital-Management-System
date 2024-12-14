package patients;


import java.util.Scanner;

public class Patients{

    private final String fileName = "patients.txt";


    public void display() {
        Scanner input = new Scanner(System.in);
        AddPatient add = new AddPatient();

        while (true) {
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("                      **Patients Section**                                        ");
            System.out.println("--------------------------------------------------------------------------------");

            System.out.println("1. Add New Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Remove Patient");
            System.out.println("5. Return to Main Menu");

           try {
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
                       add.removePatient();
                       break;
                   case 5:
                       System.out.println("Returning to Main Menu...");
                       return;
                   default:
                       System.out.println("Invalid choice. Please try again.");
               }
           }catch (Exception e){
               System.out.println(e.getMessage());
               System.out.println("Invalid input. Please enter a valid integer.");
               input.next();
           }
        }


    }

}
