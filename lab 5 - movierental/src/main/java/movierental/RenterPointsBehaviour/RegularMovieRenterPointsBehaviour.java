package movierental.RenterPointsBehaviour;

public class RegularMovieRenterPointsBehaviour implements RenterPointsBehaviour {
    @Override
    public int determineFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
