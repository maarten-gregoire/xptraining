package mock;

public class FlightBookingServiceImpl implements FlightBookingService {

	private PersistenceManager<Flight> persistenceManager;

	public FlightBookingServiceImpl(PersistenceManager<Flight> persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	@Override
    public void bookSeatOnFlight(int flightId, String person) throws FlightFullyBookedException {
		Flight flight = (Flight) persistenceManager.lookup(Flight.class, flightId);
		flight.addPassenger(person);
	}
}
