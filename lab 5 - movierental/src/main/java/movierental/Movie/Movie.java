package movierental.Movie;

import movierental.AmountBehaviour.AmountBehaviour;
import movierental.RenterPointsBehaviour.RenterPointsBehaviour;

public abstract class Movie {
	private String _title;
	private AmountBehaviour _amountBehaviour;
	private RenterPointsBehaviour _renterPointsBehaviour;
	
	public Movie(String title, AmountBehaviour amountBehaviour, RenterPointsBehaviour renterPointsBehaviour) {
		_title = title;
		_amountBehaviour = amountBehaviour;
		_renterPointsBehaviour = renterPointsBehaviour;
	}

	public String getTitle() {
		return _title;
	}

	public double determineAmount(int daysRented) {
		return _amountBehaviour.determineAmount(daysRented);
	}

	public int determineFrequentRenterPoints(int daysRented) {
		return _renterPointsBehaviour.determineFrequentRenterPoints(daysRented);
	}
}
