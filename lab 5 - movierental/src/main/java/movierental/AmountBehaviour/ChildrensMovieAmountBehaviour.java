package movierental.AmountBehaviour;

public class ChildrensMovieAmountBehaviour implements AmountBehaviour {
    @Override
    public double determineAmount(int daysRented) {
        return (daysRented > 3) ? 1.5 + (daysRented - 3) * 1.5 : 1.5;
    }
}
