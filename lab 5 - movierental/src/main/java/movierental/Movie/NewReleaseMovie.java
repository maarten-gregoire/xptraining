package movierental.Movie;

import movierental.AmountBehaviour.NewReleaseAmountBehaviour;
import movierental.RenterPointsBehaviour.NewReleaseRenterPointsBehaviour;

public class NewReleaseMovie extends Movie{
    public NewReleaseMovie(String title) {
        super(title, new NewReleaseAmountBehaviour(), new NewReleaseRenterPointsBehaviour());
    }
}
