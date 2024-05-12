package com.ps;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;


    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    ArrayList<Vehicle> inventory = new ArrayList<>();


   public  ArrayList<Vehicle> getVehicleByPrice(double min, double max){
       // min, max
       ArrayList<Vehicle> range = new ArrayList<>();

       return  range;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
       return null;
    }

    public ArrayList<Vehicle> getVehicleByYear(int minYcar, int maxYcar ){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int minMileage, int maxMileage){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByType(String Vehicletype){
        return null;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }



}
