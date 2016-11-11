package mock;

public class FlightBookingService{

    private FlightRepository flightRepository;

    public void FlightBookingService(){
        flightRepository = new FlightRepository();
    }

    public void bookSeat(int id, Passenger passenger) throws FlightFullyBookedException {
        Flight flight = flightRepository.getFlightById(id);
        flight.addPassenger(passenger);
    }
}
