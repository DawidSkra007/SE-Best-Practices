package main.java.Vehicles;

import main.java.Strategies.DefaultStrategy;
import main.java.Strategies.Strategy;
import main.java.Vehicles.Vehicle;

public class AllTerrain extends Vehicle {
    private Strategy strategy = new DefaultStrategy();

    public AllTerrain(String model) {
        super(model);
    }

    public AllTerrain(String model, Strategy strategy) {
        super(model);
        this.strategy = strategy;
    }

    public Double calcCost(int daysRented) {
        return strategy.calculateVehicleCost(this, daysRented);
    }


}
