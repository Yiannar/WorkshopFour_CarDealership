package com.ps;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {

    // read the file
    public static void getDealership(ArrayList<Vehicle> inventory){
    Scanner scanner = new Scanner(System.in);

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Inventory.txt"))){
        String line;

        while ((line = bufferedReader.readLine())!= null){
            String[] splitInput = line.split("\\|");
             int vin  = Integer.parseInt(splitInput[0]);
             int ycar = Integer.parseInt(splitInput[1]);
             String make = splitInput[2];
             String model = splitInput[3];
             String vehicleType = splitInput[4];
             String color = splitInput[5];
             int odometer = Integer.parseInt(splitInput[6]);
             double price = Double.parseDouble(splitInput[7]);

//             inventory tempDealership = new Dealership(vin, ycar,make,model, vehicleType, color, odometer, price);
//             tempDealership.add(inventory);

        }
    } catch (IOException e){
        e.printStackTrace();
    }
    }

    public static void saveDealership(){

    }

}
