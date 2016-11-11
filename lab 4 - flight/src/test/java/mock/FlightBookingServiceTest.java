package mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightBookingServiceTest {

	@InjectMocks
	private FlightBookingService flightBookingService;

	@Mock
	private FlightRepository flightRepository;

	@Test
	public void test_whenSeatBookedWithFlightIdAndPassenger_thenPassengerIsAdded() throws FlightFullyBookedException {
		Flight flight = new Flight(100);
		flight.setId(1);
		when(flightRepository.getFlightById(flight.getId())).thenReturn(flight);
		Passenger passenger = new Passenger("Arnold");
		flightBookingService.bookSeat(flight.getId(), passenger);
		assertThat(flight.getPassengers().contains(passenger)).isTrue();
	}

	@Test ( expected = FlightNotFoundException.class)
	public void test_whenSeatBookedWithIdNotFound_thenThrowException() throws FlightFullyBookedException {
		Flight flight = new Flight(100);
		flight.setId(1);
		when(flightRepository.getFlightById(flight.getId())).thenReturn(flight);
		when(flightRepository.getFlightById(flight.getId()+1)).thenThrow(FlightNotFoundException.class);
		Passenger passenger = new Passenger("Arnold");
		flightBookingService.bookSeat(flight.getId() + 1, passenger);

	}


}
