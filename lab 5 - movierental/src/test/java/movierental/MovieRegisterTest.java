package movierental;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class MovieRegisterTest {
    @Test
    public void statementForRegularMovie() {
        Movie movie1 = new Movie("Gone with the Wind");
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        MovieRegister movieRegister = new MovieRegister();
        Customer customer2 =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental1)
                        .build();
        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        String statement = movieRegister.determineStatement(customer2);
        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie() {
        Movie movie1 = new NewMovie("Star Wars");
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        MovieRegister movieRegister = new MovieRegister();
        Customer customer2 =
                new CustomerBuilder()
                        .withName("Sallie")
                        .withRentals(rental1)
                        .build();
        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        String statement = movieRegister.determineStatement(customer2);
        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrensMovie() {
        Movie movie1 = new ChildrensMovie("Madagascar");
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
       MovieRegister movieRegister = new MovieRegister();
        Customer customer2
                = new CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        String statement = movieRegister.determineStatement(customer2);
        assertEquals(expected, statement);
    }

    @Test
    public void statementForManyMovies() {
        Movie movie1 = new ChildrensMovie("Madagascar");
        Rental rental1 = new Rental(movie1, 6); // 6 day rental
        Movie movie2 = new NewMovie("Star Wars");
        Rental rental2 = new Rental(movie2, 2); // 2 day rental
        Movie movie3 = new Movie("Gone with the Wind");
        Rental rental3 = new Rental(movie3, 8); // 8 day rental
        MovieRegister movieRegister = new MovieRegister();
        Customer customer1
                = new CustomerBuilder()
                .withName("David")
                .withRentals(rental1, rental2, rental3)
                .build();
        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";
        String statement = movieRegister.determineStatement(customer1);
        assertEquals(expected, statement);
    }
}