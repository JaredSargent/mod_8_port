package automobiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.color = "Unknown";
        this.year = 0;
        this.mileage = 0;
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public String[] listVehicleInfo() {
        return new String[]{make, model, color, String.valueOf(year), String.valueOf(mileage)};
    }

    public String removeVehicle() {
        try {
            this.make = "";
            this.model = "";
            this.color = "";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Error removing vehicle: " + e.getMessage();
        }
    }

    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle updated successfully.";
        } catch (Exception e) {
            return "Error updating vehicle: " + e.getMessage();
        }
    }
}

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Automobile> inventory = new ArrayList<>();

        try {
            Automobile car = new Automobile("Toyota", "Camry", "Blue", 2020, 30000);
            inventory.add(car);
            
            System.out.println("Vehicle Information:");
            for (String info : car.listVehicleInfo()) {
                System.out.println(info);
            }

            System.out.println(car.removeVehicle());

            Automobile newCar = new Automobile("Honda", "Civic", "Red", 2022, 5000);
            inventory.add(newCar);
            System.out.println("New vehicle added.");

            System.out.println("Updated Vehicle Information:");
            for (String info : newCar.listVehicleInfo()) {
                System.out.println(info);
            }

            System.out.print("Do you want to print vehicle information to a file? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                try (FileWriter writer = new FileWriter("C:\\Temp\\Autos.txt")) {
                    for (Automobile auto : inventory) {
                        for (String info : auto.listVehicleInfo()) {
                            writer.write(info + " ");
                        }
                        writer.write("\n");
                    }
                    System.out.println("File has been written.");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

