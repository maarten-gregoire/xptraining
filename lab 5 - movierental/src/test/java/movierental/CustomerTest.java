package movierental;

import movierental.Movie.Movie;
import movierental.Movie.RegularMovie;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class CustomerTest {

	@Test
	public void testCustomer() {
		Customer c = new CustomerBuilder().build();
		assertNotNull(c);	
	}

	@Test
	public void testAddRental() {
		Customer customer2 = new CustomerBuilder().withName("Sallie").build();
		Movie movie1 = new RegularMovie("Gone with the Wind");
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
	}

	@Test
	public void testGetName() {
		Customer c = new Customer("David");
		assertEquals("David", c.getName());
	}


	
	//TODO make test for price breaks in code.
}
