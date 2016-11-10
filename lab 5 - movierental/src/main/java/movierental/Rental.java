package movierental;

import movierental.Movie.Movie;

public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double determineAmount() {
		return _movie.determineAmount(_daysRented);
	}

	public int determineFrequentRenterPoints() {
		return _movie.determineFrequentRenterPoints(_daysRented);
	}
}
