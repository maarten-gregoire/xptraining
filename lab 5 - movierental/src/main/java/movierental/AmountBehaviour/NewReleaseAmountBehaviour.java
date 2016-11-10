package movierental.AmountBehaviour;

public class NewReleaseAmountBehaviour implements AmountBehaviour {
    @Override
    public double determineAmount(int daysRented){
        return daysRented * 3;
    }
}
