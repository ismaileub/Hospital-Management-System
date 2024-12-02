package pharmacy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Medicine {
    private String name;
    private double price;
    private int stock;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFullInfo() {
        return "Name: " + name + ", Price: " + price + ", Stock: " + stock;
    }

    public void displayInformation() {
        try (BufferedReader reader = new BufferedReader(new FileReader("medicine.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading data: " + e.getMessage());
        }
    }
}

