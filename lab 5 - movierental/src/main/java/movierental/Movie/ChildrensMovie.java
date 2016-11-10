package movierental.Movie;

import movierental.AmountBehaviour.ChildrensMovieAmountBehaviour;
import movierental.RenterPointsBehaviour.RegularMovieRenterPointsBehaviour;

public class ChildrensMovie extends Movie{
    public ChildrensMovie(String title) {
        super(title, new ChildrensMovieAmountBehaviour(), new RegularMovieRenterPointsBehaviour());
    }
}