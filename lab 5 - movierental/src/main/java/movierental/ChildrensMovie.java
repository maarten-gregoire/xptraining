package movierental;

public class ChildrensMovie extends Movie{
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double determineAmount(int daysRented){
        if (daysRented > 3)
            return 1.5 + (daysRented - 3) * 1.5;
        return 1.5;
    }
}