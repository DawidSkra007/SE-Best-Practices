package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.*;
import main.java.Vehicles.AllTerrain;
import main.java.Vehicles.Motorbike;
import main.java.Vehicles.Vehicle;
import main.java.Vehicles.car;
import org.junit.Test;

public class CustomerTest {

  @Test
  public void testCustomer() {
    Customer c = new CustomerBuilder().build();
    assertNotNull(c);
  }
  
  @Test
  public void testGetName() {
    Customer c = new Customer("Sean");
    assertEquals("Sean", c.getName());
  }

  @Test
  public void statementForCar() {
    //Vehicle vehicle1 = new Vehicle("Peugeot 207", Vehicle.CAR);
    Vehicle vehicle1 = new car("Peugeot 207");
    Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
    StatementBuilder builder = new StatementBuilder();
    Customer customer2 =
        new CustomerBuilder()
    .withName("Aoife")
    .withRentals(rental1)
    .build();
    String expected = "Rental Record for Aoife\n" +
        "\tPeugeot 207\t3.5\n" +
        "Amount owed is 3.5\n" +
        "You earned 1 frequent rental points";
    //String statement = customer2.statement();
    String statement = builder.buildStatement(customer2);
    assertEquals(expected, statement);
  }

  @Test
  public void statementForAllTerrainVehicle() {
    //Vehicle vehicle1 = new Vehicle("Landrover Freelander", Vehicle.ALL_TERRAIN);
    Vehicle vehicle1 = new AllTerrain("Landrover Freelander");
    Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
    StatementBuilder builder = new StatementBuilder();
    Customer customer2 =
        new CustomerBuilder()
    .withName("Aoife")
    .withRentals(rental1)
    .build();
    String expected = "Rental Record for Aoife\n" +
        "\tLandrover Freelander\t9.0\n" +
        "Amount owed is 9.0\n" +
        "You earned 2 frequent rental points";
    //String statement = customer2.statement();
    String statement = builder.buildStatement(customer2);
    assertEquals(expected, statement);
  }

  @Test
  public void statementForMotorbike() {
    //main.java.Vehicles.Vehicle vehicle1 = new main.java.Vehicles.Vehicle("Honda 50", main.java.Vehicles.Vehicle.MOTORBIKE);
    Vehicle vehicle1 = new Motorbike("Honda 50");
    Rental rental1 = new Rental(vehicle1, 3); // 3 day rental
    StatementBuilder builder = new StatementBuilder();
    Customer customer2
    = new CustomerBuilder()
    .withName("Aoife")
    .withRentals(rental1)
    .build();
    String expected = "Rental Record for Aoife\n" +
        "\tHonda 50\t1.5\n" +
        "Amount owed is 1.5\n" +
        "You earned 1 frequent rental points";
    //String statement = customer2.statement();
    String statement = builder.buildStatement(customer2);
    assertEquals(expected, statement);
  }

  @Test
  public void statementForManyRentals() {
    //main.java.Vehicles.Vehicle vehicle1 = new main.java.Vehicles.Vehicle("Honda 50", main.java.Vehicles.Vehicle.MOTORBIKE);
    Vehicle vehicle1 = new Motorbike("Honda 50");
    Rental rental1 = new Rental(vehicle1, 6); // 6 day rental
    //main.java.Vehicles.Vehicle vehicle2 = new main.java.Vehicles.Vehicle("Santa Fe", main.java.Vehicles.Vehicle.ALL_TERRAIN);
    Vehicle vehicle2 = new AllTerrain("Santa Fe");
    Rental rental2 = new Rental(vehicle2, 2); // 2 day rental
    //main.java.Vehicles.Vehicle vehicle3 = new main.java.Vehicles.Vehicle("Peugeot 207", main.java.Vehicles.Vehicle.CAR);
    Vehicle vehicle3 = new car("Peugeot 207");
    Rental rental3 = new Rental(vehicle3, 8); // 8 day rental
    StatementBuilder builder = new StatementBuilder();
    Customer customer1
    = new CustomerBuilder()
    .withName("Sean")
    .withRentals(rental1, rental2, rental3)
    .build();
    String expected = "Rental Record for Sean\n" +
        "\tHonda 50\t6.0\n" +
        "\tSanta Fe\t6.0\n" +
        "\tPeugeot 207\t11.0\n" +
        "Amount owed is 23.0\n" +
        "You earned 4 frequent rental points";
    //String statement = customer1.statement();
    String statement = builder.buildStatement(customer1);
    assertEquals(expected, statement);
  }

  //TODO make test for price breaks in code.
}

/* 
 * COMP47480 note: test.java.CustomerBuilder is a simple implementation of the Builder design pattern
 * used here to make creating main.java.Customer objects safer. You cna just use it "as is."
 * See https://dzone.com/articles/design-patterns-the-builder-pattern for more details.
 */

class CustomerBuilder {

  public Customer build() {
    Customer result = new Customer(name);
    for (Rental rental : rentals) {
      result.addRental(rental);
    }
    return result;
  }

  public CustomerBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CustomerBuilder withRentals(Rental... rentals) {
    Collections.addAll(this.rentals, rentals);
    return this;
  }
  
  private String name = "default";
  private List<Rental> rentals = new ArrayList<Rental>();
}