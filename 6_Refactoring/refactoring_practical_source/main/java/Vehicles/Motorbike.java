package main.java.Vehicles;

import main.java.Strategies.DefaultStrategy;
import main.java.Strategies.Strategy;
import main.java.Vehicles.Vehicle;

public class Motorbike extends Vehicle {

    private Strategy strategy = new DefaultStrategy();
    public Motorbike(String model) {
        super(model);
    }

    public Motorbike(String model, Strategy strategy) {
        super(model);
        this.strategy = strategy;
    }

    public Double calcCost(int daysRented) {
        return strategy.calculateVehicleCost(this, daysRented);
    }


}
