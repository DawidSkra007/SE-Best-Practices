package main.java;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public List<Rental> getRentals() {
    return rentals;
  }

  private String name;
  private List<Rental> rentals = new ArrayList<Rental>();

}
