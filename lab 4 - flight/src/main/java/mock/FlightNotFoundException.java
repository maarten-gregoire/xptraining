package mock;

/**
 * Created by maarteng on 11/11/2016.
 */
public class FlightNotFoundException extends Throwable {
    FlightNotFoundException(String message) {
        super(message);
    }
}
