package movierental;

import java.util.List;

public class MovieRegister {

    public String determineStatement(Customer customer) {
        String resultText = "Rental Record for " + customer.getName() + "\n";
        for (Rental rental: customer.getRentals()) {
            resultText += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.determineAmount()) + "\n";
        }
        resultText += "Amount owed is " + String.valueOf(determineTotalAmount(customer.getRentals())) + "\n";
        resultText += "You earned " + String.valueOf(determineFrequentRenterPoints(customer.getRentals())) + " frequent renter points";
        return resultText;
    }

    private int determineFrequentRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental rental: rentals) {
            frequentRenterPoints += rental.determineFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double determineTotalAmount(List<Rental> rentals) {
        double totalAmount = 0;
        for (Rental rental: rentals) {
            totalAmount += rental.determineAmount();
        }
        return totalAmount;
    }
}
