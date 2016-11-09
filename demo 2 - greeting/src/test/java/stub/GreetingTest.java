package stub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GreetingTest {

	@InjectMocks
	private Greeting greeting;

	@Mock
	private TimeProvider timeProvider;

	@Mock
	private GreetingCounter greetingCounter;

	@Test
	public void morning() {
		when(timeProvider.isAfternoon()).thenReturn(false);

		String message = greeting.getGreeting();

		assertThat(message).isEqualTo("Good Morning");
		verify(greetingCounter).increaseCounter();
		verify(greetingCounter).increaseCounter();
		verify(greetingCounter).increaseCounter();
		verify(greetingCounter).increaseCounter();
		verify(greetingCounter).increaseCounter();
		verify(greetingCounter).increaseCounter();
		verifyNoMoreInteractions(greetingCounter);
	}

	@Test
	public void afternoon() {
		when(timeProvider.isAfternoon()).thenReturn(true);

		String message = greeting.getGreeting();

		assertThat(message).isEqualTo("Good afternoon");
		verify(greetingCounter).increaseCounter();
	}

}
