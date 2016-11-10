package movierental;

import java.util.List;

public class MovieRegister {
    public String determineStatement(Customer customer) {
        String resultText = "Rental Record for " + customer.getName() + "\n";
        for (Rental rental: customer.getRentals()) {
            resultText += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.determineAmount()) + "\n";
        }
        resultText += "Amount owed is " + String.valueOf(determineTotalAmount(customer.getRentals())) + "\n"
                + "You earned " + String.valueOf(determineFrequentRenterPoints(customer.getRentals()))
                + " frequent renter points";
        return resultText;
    }

    private int determineFrequentRenterPoints(List<Rental> rentals) {
        return rentals.stream()
                .mapToInt(Rental::determineFrequentRenterPoints)
                .sum();
    }

    private double determineTotalAmount(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(Rental::determineAmount)
                .sum();
    }
}
