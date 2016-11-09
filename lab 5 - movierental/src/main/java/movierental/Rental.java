package movierental;

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

	public int getFrequentRenterPoints(){
		return _movie.getFrequentRenterPoints(_daysRented);
	}

	public double calculatePrice() {
		return _movie.calculatePrice(_daysRented);
	}
}
