package mock;

public interface FlightBookingService {

	void bookSeatOnFlight(int flightId, String person) throws FlightFullyBookedException;
	
}
