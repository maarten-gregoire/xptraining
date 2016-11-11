package mock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightTest {

	@Test
	public void test_givenFlight_thenHasAListOfPassengers(){
		Flight flight = new Flight(1);
		assertThat(flight.getPassengers()).isNotNull();
	}

	@Test
	public void test_givenFlight_thenHasId(){
		Flight flight = new Flight(1);
		assertThat(flight.getId()).isNotNull();
	}

	@Test
	public void test_givenFlight_thenPassengersCanBeAdded() throws FlightFullyBookedException {
		Flight flight = new Flight(1);
		Passenger passenger = new Passenger("Fons");
		flight.addPassenger(passenger);
		assertThat(flight.getPassengers()).contains(passenger);
	}

	@Test
	public void test_givenFlight_thenCanGetNumberOfPassengers() throws FlightFullyBookedException {
		Flight flight = new Flight(2);
		Passenger passenger1 = new Passenger("Fons");
		Passenger passenger2 = new Passenger("Albert");
		flight.addPassenger(passenger1);
		flight.addPassenger(passenger2);
		assertThat(flight.getNumberOfPassengers()).isEqualTo(2);
	}

	@Test
	public void test_givenFlightWithPassenger_thenHasPassengerOnFlightIsTrue() throws FlightFullyBookedException {
		Flight flight = new Flight(1);
		Passenger passenger = new Passenger("Philip");
		flight.addPassenger(passenger);
		assertThat(flight.hasPassengerOnFlight(passenger)).isTrue();
	}

	@Test
	public void test_givenFlightWithoutPassenger_thenHasPassengerOnFlightIsFalse(){
		Flight flight = new Flight(1);
		Passenger passenger = new Passenger("James");
		assertThat(flight.hasPassengerOnFlight(passenger)).isFalse();
	}

	@Test(expected = FlightFullyBookedException.class)
	public void test_givenFullFlightWithAddedPassenger_thenThrowException() throws FlightFullyBookedException {
		Flight flight = new Flight(1);
		Passenger passenger1 = new Passenger("James");
		Passenger passenger2 = new Passenger("Jamie");
		flight.addPassenger(passenger1);
		flight.addPassenger(passenger2);
	}



}
