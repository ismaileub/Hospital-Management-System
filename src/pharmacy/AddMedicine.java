package pharmacy;

import common.Common;
import java.util.Scanner;

public class AddMedicine extends Common {

    Medicine obj = new Medicine();
    Scanner input = new Scanner(System.in);

    @Override
    public void details() {
        System.out.print("Enter medicine name: ");
        String name = input.next();
        System.out.print("Enter price: ");
        double price = input.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stock = input.nextInt();

        obj.setName(name);
        obj.setPrice(price);
        obj.setStock(stock);

        String allData = obj.getFullInfo();
        writeDataInDatabase(allData, "medicine.txt");
    }


}
