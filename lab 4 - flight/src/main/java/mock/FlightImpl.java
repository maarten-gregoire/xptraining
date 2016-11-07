package mock;

import java.util.HashSet;
import java.util.Set;

public class FlightImpl implements Flight {

	private final int maxNumberOfSeats;

	private Set<String> passengers;

	public FlightImpl(int maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
		this.passengers = new HashSet<String>();
	}

	@Override
    public void addPassenger(String person) throws FlightFullyBookedException {
		if (isFlightFull()) {
			throw new FlightFullyBookedException("Flight is already full!");
		}
		passengers.add(person);
	}

	private boolean isFlightFull() {
		return numberOfPassengers() >= maxNumberOfSeats;
	}
	
	@Override
    public int numberOfPassengers() {
		return passengers.size();
	}

	@Override
    public boolean isPassengerOnFlight(String person) {
		return passengers.contains(person);
	}

	@Override
    public Set<String> listPassengers() {
		return passengers;
	}

	@Override
    public int maxNumberOfSeats() {
		return maxNumberOfSeats;
	}
	
}
