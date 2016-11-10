package movierental.AmountBehaviour;

public class RegularMovieAmountBehaviour implements AmountBehaviour {
    @Override
    public double determineAmount(int daysRented) {
        return (daysRented > 2) ? 2 + (daysRented - 2) * 1.5 :  2;
    }
}
