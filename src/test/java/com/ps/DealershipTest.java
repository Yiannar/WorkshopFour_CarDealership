package com.ps;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DealershipTest {
    private Dealership dealership;

    @BeforeEach
    void setUp() {
        // Create sample data for testing
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(101, 2010, "Toyota", "Camry", "Sedan", "Blue", 10000, 15000.0));
        vehicles.add(new Vehicle(102, 2015, "Honda", "Accord", "Sedan", "Red", 20000, 20000.0));
        vehicles.add(new Vehicle(103, 2018, "Ford", "Escape", "SUV", "Black", 30000, 25000.0));

        dealership = new Dealership("Test Dealership", "123 Test St", "555-123-4567", vehicles);
    }

    @Test
    void testGetVehicleByPrice() {
        // Test when vehicles are within the price range
        ArrayList<Vehicle> result = dealership.getVehicleByPrice(20000, 25000);
        assertEquals(2, result.size());

        // Test when no vehicles are within the price range
        result = dealership.getVehicleByPrice(30000, 35000);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetVehicleByMakeModel() {
        // Test when vehicles match make and model
        ArrayList<Vehicle> result = dealership.getVehicleByMakeModel("Toyota", "Camry");
        assertEquals(1, result.size());

        // Test when no vehicles match make and model
        result = dealership.getVehicleByMakeModel("Chevrolet", "Impala");
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetVehicleByYear() {
        // Test when vehicles are within the year range
        ArrayList<Vehicle> result = dealership.getVehicleByYear(2010, 2015);
        assertEquals(2, result.size());

        // Test when no vehicles are within the year range
        result = dealership.getVehicleByYear(2020, 2025);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetVehicleByColor() {
        // Test when vehicles match the color
        ArrayList<Vehicle> result = dealership.getVehicleByColor("Blue");
        assertEquals(1, result.size());

        // Test when no vehicles match the color
        result = dealership.getVehicleByColor("Green");
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetVehicleByMileage() {
        // Test when vehicles are within the mileage range
        ArrayList<Vehicle> result = dealership.getVehicleByMileage(10000, 20000);
        assertEquals(2, result.size());

        // Test when no vehicles are within the mileage range
        result = dealership.getVehicleByMileage(5000, 7000);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetVehicleByType() {
        // Test when vehicles match the type
        ArrayList<Vehicle> result = dealership.getVehicleByType("Sedan");
        assertEquals(2, result.size());

        // Test when no vehicles match the type
        result = dealership.getVehicleByType("Truck");
        assertTrue(result.isEmpty());
    }

    @Test
    void testAddVehicle() {
        // Test adding a vehicle
        int initialSize = dealership.getAllVehicles().size();
        dealership.addVehicle(new Vehicle(104, 2020, "Chevrolet", "Silverado", "Truck", "Silver", 5000, 35000.0));
        assertEquals(initialSize + 1, dealership.getAllVehicles().size());
    }

    @Test
    void testRemoveVehicle() {
        // Test removing a vehicle
        int initialSize = dealership.getAllVehicles().size();
        dealership.removeVehicle(dealership.getAllVehicles().get(0));
        assertEquals(initialSize - 1, dealership.getAllVehicles().size());
    }
}
