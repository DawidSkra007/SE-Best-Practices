package main.java;

import main.java.Customer;
import main.java.Rental;

import java.util.List;

public class StatementBuilder {

    public static String buildStatement(Customer customer) {
        String finalStatement = "Rental Record for " + customer.getName() + "\n";

        for (Rental rental: customer.getRentals()) {
            finalStatement += "\t" + rental.getVehicle().getModel() + "\t" + String.valueOf(rental.costs()) + "\n";
        }

        finalStatement += "Amount owed is " + String.valueOf(calculateCost(customer.getRentals())) + "\n";
        finalStatement += "You earned " + String.valueOf(calculatePoints(customer.getRentals())) + " frequent rental points";
        return finalStatement;
    }

    public String buildHTML(Customer customer) {
        String htmlStat = "<html><head><title>StatementPage</title></head><body>";

        htmlStat += buildStatement(customer);

        htmlStat += "</body></html>";
        return htmlStat;
    }

    private static double calculateCost(List<Rental> rentals) {
        double total = 0;
        for(Rental rental: rentals) {
            total += rental.costs();
        }
        return total;
    }

    private static int calculatePoints(List<Rental> rentals) {
        int points = 0;
        for(Rental rental: rentals) {
            points += rental.calculatePoints();
        }
        return points;
    }

}
