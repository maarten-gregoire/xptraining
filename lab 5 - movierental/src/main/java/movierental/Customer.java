package movierental;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String determineCheckoutStatement() {
		return determineResultText(determineTotalAmount(), determineFrequentRenterPoints());
	}

	private int determineFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental: _rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private double determineTotalAmount() {
		double totalAmount = 0;
		for (Rental rental: _rentals) {
			totalAmount += rental.calculatePrice();
		}
		return totalAmount;
	}

	private String determineResultText(double totalAmount, int frequentRenterPoints) {
		String resultText = "Rental Record for " + getName() + "\n";

		for (Rental rental: _rentals) {
			resultText += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.calculatePrice()) + "\n";
		}

		resultText += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		resultText += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return resultText;
	}
}
