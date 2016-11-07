package mock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FlightTest {

	private static final String JEAN_MICHEL_SAIVE = "Jean-Mi";
	private static final String PHILIPPE_SAIVE = "Philippe";

	@Test
	public void testAddPassengerToFlight() throws FlightFullyBookedException {
		FlightImpl flight = new FlightImpl(150);
		flight.addPassenger(JEAN_MICHEL_SAIVE);

		assertThat(flight.numberOfPassengers()).isEqualTo(1);
		assertThat(flight.isPassengerOnFlight(JEAN_MICHEL_SAIVE)).isTrue();
	}

	@Test
	public void testCanNotAddPassengerToFullyBookedFlight() throws FlightFullyBookedException {
		FlightImpl flight = new FlightImpl(1);
		flight.addPassenger(JEAN_MICHEL_SAIVE);

		assertThatThrownBy(() -> flight.addPassenger(PHILIPPE_SAIVE))
				.isInstanceOf(FlightFullyBookedException.class);
	}
}
