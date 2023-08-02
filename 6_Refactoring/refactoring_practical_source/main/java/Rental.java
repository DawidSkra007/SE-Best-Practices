package main.java;

import main.java.Strategies.DefaultStrategy;
import main.java.Strategies.Strategy;
import main.java.Vehicles.AllTerrain;
import main.java.Vehicles.Vehicle;

// Represents a rental of a vehicle
public class Rental {

  private Vehicle vehicle;
  private int daysRented;

  private Strategy strategy = new DefaultStrategy();

  public Rental(Vehicle vehicle, int daysRented) {
    this.vehicle = vehicle;
    this.daysRented = daysRented;
  }

  public void setStrategy(Strategy abstractStrategy) {
    this.strategy = abstractStrategy;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public int calculatePoints() {
    return strategy.calculateRentalPoints(vehicle);
  }

  public String getModel() {
    return vehicle.getModel();
  }
  public double costs() {
    return vehicle.calcCost(getDaysRented());
  }

}
