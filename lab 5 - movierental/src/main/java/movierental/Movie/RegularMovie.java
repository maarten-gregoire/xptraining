package movierental.Movie;

import movierental.AmountBehaviour.RegularMovieAmountBehaviour;
import movierental.RenterPointsBehaviour.RegularMovieRenterPointsBehaviour;

public class RegularMovie extends Movie{
    public RegularMovie(String title) {
        super(title, new RegularMovieAmountBehaviour(), new RegularMovieRenterPointsBehaviour());
    }
}
