package main.java.Strategies;


import main.java.Vehicles.Vehicle;

public abstract class Strategy {

    public abstract double calculateVehicleCost(Vehicle vehicle, int days);

    public abstract int calculateRentalPoints(Vehicle vehicle);
}
