package movierental.RenterPointsBehaviour;

public class NewReleaseRenterPointsBehaviour implements RenterPointsBehaviour {
    @Override
    public int determineFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
