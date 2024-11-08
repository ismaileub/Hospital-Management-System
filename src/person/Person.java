package person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Person {
    public int id;
    public String name;
    public int age;
    public String gender;
    public String phone;

    public Person() {}

    public Person(int id, String name, int age, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Abstract method for specific details in subclasses
    public abstract void details();


    // Method to display information from a given file
    public void displayInformation(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading data: " + e.getMessage());
        }
    }
}
