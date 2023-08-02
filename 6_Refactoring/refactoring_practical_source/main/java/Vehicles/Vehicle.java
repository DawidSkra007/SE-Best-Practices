package main.java.Vehicles;

public abstract class Vehicle {

  public Vehicle(String model) {
    this.model = model;
  }

  public abstract Double calcCost(int daysRented);

  public int getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(int arg) {
    vehicleType = arg;
  }

  public String getModel() {
    return model;
  }

  private String model;
  private int vehicleType;
}
