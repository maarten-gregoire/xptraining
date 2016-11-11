package mock;

import java.util.ArrayList;
import java.util.List;

public class Flight {

	private List<Passenger> passengers = new ArrayList<>();
	private int id;
	private int maximumSeats;

	public Flight(int maximumSeats) {
		this.maximumSeats = maximumSeats;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public int getId() {
		return id;
	}

	public void addPassenger(Passenger passenger) throws FlightFullyBookedException {
		if (passengers.size() < maximumSeats)
			passengers.add(passenger);
		else
			throw new FlightFullyBookedException("Flight fully booked");
	}

	public int getNumberOfPassengers() {
		return passengers.size();
	}

	public boolean hasPassengerOnFlight(Passenger passenger) {
		if (passengers.contains(passenger))
			return true;
		return false;
	}

	public void setId(int id) {
		this.id = id;
	}
}
