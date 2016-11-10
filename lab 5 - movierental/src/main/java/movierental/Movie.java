package movierental;

public class Movie {

	private String _title;
	
	public Movie(String title) {
		_title = title;
	}
	public String getTitle() {
		return _title;
	}

	public double determineAmount(int daysRented) {
		if (daysRented > 2)
			return 2 + (daysRented - 2) * 1.5;
		return 2;
	}

	public int determineFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
