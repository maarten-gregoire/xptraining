package org.cegeka.petshop;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class PetShopTest {

	@Mock
	private MailClient mailClient;

	@InjectMocks
	private Shop shop;

	@Rule
	public MockServerRule mockServerRule = new MockServerRule(this, 9002);
	private MockServerClient mockServerClient;

	/*
	@BeforeClass
	public static void beforeClass() {
		initMocks(PetShopTest.class);
	}
	*/
	/*
	@Before
	public void setup() {
		shop = new Shop();
		//reset(mailClient);
	}
	*/

	private boolean addItem(String item) {
		return shop.addItem(item);
	}

	@Test
	public void addItem_whenItem_thenAddsItemToStock() {
		String item = "Doggy Gucci bag";
		addItem(item);

		Set<String> items = shop.getItemsInStock();

		assertThat(items.contains(item)).isTrue();
	}

	@Test
	public void sendMail_whenItemAdded() {
		String item = "Doggy Gucci bag";
		addItem(item);

		verify(mailClient, times(1)).sendMail(item);
	}

	@Test
	public void cllRest_whenItemAdded() {
		String item = "Doggy Gucci bag";

		mockServerClient.when(
				HttpRequest.request()
						.withBody(item)
						.withPath("/additem")
						.withMethod("POST"))
				.respond(HttpResponse.response()
						.withStatusCode(200));

		Assertions.assertThat(addItem(item)).isTrue();
	}

}
