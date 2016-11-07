package stub;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class GreetingTest {

	private Greeting g;

	@Before
	public void setUp() throws Exception {
		g = new Greeting();
	}

	@Test
	public void morning() {
		String s = g.getGreeting();
		Assertions.assertThat(s).isEqualTo("Good Morning");
	}

}
