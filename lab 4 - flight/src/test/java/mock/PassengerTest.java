package mock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassengerTest {

    @Test
    public void test_givenPassenger_thenHasName(){
        Passenger passenger = new Passenger("name");
        assertThat(passenger.getName()).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_givenNullAsName_thenThrowException(){
        Passenger passenger = new Passenger(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_givenEmptyName_thenThrowException(){
        Passenger passenger = new Passenger("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_givenSpaces_thenThrowException(){
        Passenger passenger = new Passenger("    ");
    }

    @Test
    public void test_givenNameStartingOrEndingWithSpaces_thenTrimSpaces(){
        Passenger passenger = new Passenger("  passenger    ");
        assertThat(passenger.getName()).isEqualTo("passenger");
    }
}