package stub;

public class Greeting {

	private TimeProvider timeProvider;

	private GreetingCounter greetingCounter;
	
	public String getGreeting() {
		greetingCounter.increaseCounter();
		if (timeProvider.isAfternoon()) {
			return "Good afternoon";
		}

		return "Good Morning";
	}

}
