package movierental;

public class NewMovie extends Movie{

    public NewMovie(String title) {
        super(title);
    }

    @Override
    public int determineFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }

    @Override
    public double determineAmount(int daysRented){
        return daysRented * 3;
    }

}
