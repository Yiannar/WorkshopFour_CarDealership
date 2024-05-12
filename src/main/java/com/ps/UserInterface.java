package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
     static Scanner scanner = new Scanner(System.in);
     static Dealership dealership;

    public static void display (){
        init();

        int mainMenuCommand;
        do {
            System.out.println("\n Please choose from the following options:\n");
            System.out.println("1) Display vehicles by price");
            System.out.println("2) Display vehicles by make and model");
            System.out.println("3) Display vehicles by year");
            System.out.println("4) Display vehicles by color");
            System.out.println("5) Display vehicles by mileage");
            System.out.println("6) Display vehicles by type");
            System.out.println("7) Display all vehicles");
            System.out.println("8) Add a new vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("10) Exit");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    // Exit the program
                    System.out.println("Exiting...");

            }
        } while (mainMenuCommand !=10);
    }

    private static void init(){

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        dealership = dealershipFileManager.getDealerShip();

    }



    public static void processGetByPriceRequest() {
        System.out.println("Enter minimum price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter maximum price:");
        double maxPrice = scanner.nextDouble();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByPrice(minPrice, maxPrice);
        displayVehicles(filteredVehicles);
    }

    public static void processGetByMakeModelRequest() {
        System.out.println("Enter make:");
        String make = scanner.next();
        System.out.println("Enter model:");
        String model = scanner.next();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByMakeModel(make, model);
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified make and model.");
        } else {
            System.out.println("Vehicles matching make '" + make + "' and model '" + model + "':");
            displayVehicles(filteredVehicles);
        }
    }

    public static void processGetByYearRequest() {
        System.out.println("Enter minimum year:");
        int minYear = scanner.nextInt();
        System.out.println("Enter maximum year:");
        int maxYear = scanner.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByYear(minYear, maxYear);
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found within the specified year range.");
        } else {
            System.out.println("Vehicles within the year range " + minYear + " - " + maxYear + ":");
            displayVehicles(filteredVehicles);
        }
    }

    public static void processGetByColorRequest() {
        System.out.println("Enter vehicle color:");
        String color = scanner.next();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified color.");
        } else {
            System.out.println("Vehicles with color '" + color + "':");
            displayVehicles(filteredVehicles);
        }
    }

    public static void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage:");
        int minMileage = scanner.nextInt();
        System.out.println("Enter maximum mileage:");
        int maxMileage = scanner.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByMileage(minMileage, maxMileage);
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found within the specified mileage range.");
        } else {
            System.out.println("Vehicles within the mileage range " + minMileage + " - " + maxMileage + ":");
            displayVehicles(filteredVehicles);
        }
    }

    public static void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.next();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByType(vehicleType);
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified type.");
        } else {
            System.out.println("Vehicles of type '" + vehicleType + "':");
            displayVehicles(filteredVehicles);
        }
    }

    public static void processGetAllVehicleRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public static void processAddVehicleRequest() {
        try {
            System.out.println("Enter vehicle details:");
            System.out.println("VIN:");
            int vin = scanner.nextInt();
            System.out.println("Year:");
            int year = scanner.nextInt();
            System.out.println("Make:");
            String make = scanner.next();
            System.out.println("Model:");
            String model = scanner.next();
            System.out.println("Type:");
            String type = scanner.next();
            System.out.println("Color:");
            String color = scanner.next();
            System.out.println("Odometer:");
            int odometer = scanner.nextInt();
            System.out.println("Price:");
            double price = scanner.nextDouble();

            // Create a new Vehicle object with the entered details
            Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

            // Add the new vehicle to the dealership's inventory
            dealership.addVehicle(newVehicle);

            System.out.println("Vehicle added successfully.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Vehicle not added.");
            // Clear scanner input buffer
            scanner.nextLine();
        }
    }

    public static void processRemoveVehicleRequest() {
        try {
            System.out.println("Enter VIN of the vehicle to remove:");
            int vinToRemove = scanner.nextInt();

            Vehicle vehicleToRemove = null;
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                if (vehicle.getVin() == vinToRemove) {
                    vehicleToRemove = vehicle;
                    break;
                }
            }

            if (vehicleToRemove != null) {
                dealership.removeVehicle(vehicleToRemove);
                System.out.println("Vehicle with VIN " + vinToRemove + " removed successfully.");
            } else {
                System.out.println("Vehicle with VIN " + vinToRemove + " not found in the inventory.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Vehicle not removed.");
        }
    }



    public static void displayVehicles(ArrayList<Vehicle> vehicles) {
        // Define column widths for each attribute
        int vinWidth = 8;
        int yearWidth = 6;
        int makeWidth = 12;
        int modelWidth = 12;
        int typeWidth = 10;
        int colorWidth = 8;
        int odometerWidth = 10;
        int priceWidth = 10;

        // Header row
        System.out.printf("%-" + vinWidth + "s | %-" + yearWidth + "s | %-" + makeWidth + "s | %-" + modelWidth + "s | %-" + typeWidth + "s | %-" + colorWidth + "s | %-" + odometerWidth + "s | %-" + priceWidth + "s%n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");

        // Separator row
        System.out.println("-".repeat(vinWidth + yearWidth + makeWidth + modelWidth + typeWidth + colorWidth + odometerWidth + priceWidth + 7 * 2));

        // Data rows
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-" + vinWidth + "d | %-" + yearWidth + "d | %-" + makeWidth + "s | %-" + modelWidth + "s | %-" + typeWidth + "s | %-" + colorWidth + "s | %-" + odometerWidth + "d | %-" + priceWidth + ".2f%n",
                    vehicle.getVin(), vehicle.getYcar(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

}
