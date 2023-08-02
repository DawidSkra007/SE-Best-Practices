package main.java.Strategies;

import main.java.Vehicles.AllTerrain;
import main.java.Vehicles.Motorbike;
import main.java.Vehicles.Vehicle;
import main.java.Vehicles.car;

import java.awt.*;

import static java.lang.System.exit;

public class DefaultStrategy extends Strategy {
    private static int rentedDays = 0;
    @Override
    public double calculateVehicleCost(Vehicle vehicle, int days) {
        rentedDays = days;
        if(vehicle instanceof AllTerrain) {
            return terrainCost();
        } else if (vehicle instanceof car) {
            return carCost();
        } else if (vehicle instanceof Motorbike) {
            return motorbikeCost();
        } else {
            exit(1);
        }
        return 0;
    }

    @Override
    public int calculateRentalPoints(Vehicle vehicle) {
        int points = 1;
        System.out.println("Points:" + points);
        if ((vehicle instanceof AllTerrain) && rentedDays > 1) {
            points++;
            System.out.println("is all terrain:" + points);
        }
        return points;
    }

    private double carCost() {
        double thisAmount = 2;
        if (rentedDays > 2)
            thisAmount += (rentedDays - 2) * 1.5;
        return thisAmount;
    }

    private double terrainCost() {
        return rentedDays * 3;
    }

    private double motorbikeCost() {
        double thisAmount = 1.5;
        if (rentedDays > 3)
            thisAmount += (rentedDays - 3) * 1.5;
        return thisAmount;
    }
}
