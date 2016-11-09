package movierental;

public class Movie {
	
	private String _title;

	public Movie(String title) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}
	
	public int getFrequentRenterPoints(int daysRented){
		return 1;
	}

	public double calculatePrice(int daysRented) {
		if (daysRented > 2)
			return 2 + (daysRented - 2) * 1.5;
		return 2;
	}
}
