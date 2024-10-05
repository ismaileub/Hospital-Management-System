import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("      *** Welcome to Hospital and Health Care Management System  ***");
        System.out.println("--------------------------------------------------------------------------------");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MMM d yyyy");
        String currentDate = dateFormat.format(date);

        LocalTime time = LocalTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formatedTime = time.format(formater);

        System.out.print("       Date: " +currentDate +"                            "+ "Time: " +formatedTime);

        Scanner input = new Scanner(System.in);

        System.out.println("\n                                 MAIN MENU");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. Doctors Section\n2. Patients Section\n3. Pharmacy Section\n4.Hospital Facilities\n5. Exit");
        System.out.println("-----------------------------------------------------------------------------------");


            while(true){

                System.out.print("Enter your option: ");
                int n =input.nextInt();

                if (n >= 1 && n <= 5){
                    switch(n){
                        case 1:
                            Doctors d = new Doctors();
                            d.display();
                            break;

                        case 2:
                            Patients p = new Patients();
                            p.display();
                            break;

                        case 3:
                            Pharmacy ph = new Pharmacy();
                            ph.display();
                            break;

                        case 4:
                            Facilities f = new Facilities();
                            f.display();
                            break;


                        case 5:
                            System.out.println("Exiting the system... Goodbye!");
                            return; // Exit the loop and program


                    }

                    break;
                }


                else {
                    System.out.println("Enter a valid option from (1, 2, 3, 4, or 5)");
                }

            }

        }
    }
