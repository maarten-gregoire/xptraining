package mock;

import java.util.Set;

public interface Flight {

	void addPassenger(String person) throws FlightFullyBookedException;
	boolean isPassengerOnFlight(String person);
	Set<String> listPassengers();
	int numberOfPassengers();
	int maxNumberOfSeats();
	
}
