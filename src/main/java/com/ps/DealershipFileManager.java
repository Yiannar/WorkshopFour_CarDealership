package com.ps;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {

    public static Dealership getDealerShip(){
        ArrayList<Vehicle> inventory = new ArrayList<>();
        String dealershipName = "";
        String dealershipAddress = "";
        String dealershipPhone = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Inventory.txt"))) {
            String line;

            // Read the first line for dealership information
            line = bufferedReader.readLine();
            String[] dealershipInfo = line.split("\\|");
            dealershipName = dealershipInfo[0];
            dealershipAddress = dealershipInfo[1];
            dealershipPhone = dealershipInfo[2];

            // Read vehicle details
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitInput = line.split("\\|");
                int vin = Integer.parseInt(splitInput[0]);
                int ycar = Integer.parseInt(splitInput[1]);
                String make = splitInput[2];
                String model = splitInput[3];
                String vehicleType = splitInput[4];
                String color = splitInput[5];
                int odometer = Integer.parseInt(splitInput[6]);
                double price = Double.parseDouble(splitInput[7]);

                Vehicle vehicle = new Vehicle(vin, ycar, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Dealership(dealershipName, dealershipAddress, dealershipPhone, inventory);
    }

    public static void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Inventory.txt"))) {
            // Write dealership information to the file
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            // Write vehicle details to the file
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYcar() + "|" +
                        vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" + vehicle.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
