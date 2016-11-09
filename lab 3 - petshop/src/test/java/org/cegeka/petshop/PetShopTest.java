package org.cegeka.petshop;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.mockserver.model.HttpResponse;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RunWith(MockitoJUnitRunner.class)
public class PetShopTest {

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this, 8080);
    private MockServerClient mockServerClient;

    @InjectMocks
	private Shop shop;

    @Mock
    private EmailServer emailServer;
    private StockProvider stockProvider;

	private void addItem(String item) {
		shop.addItem(item);
	}

	@Test
	public void addItem_whenItem_thenAddsItemToStock() {
		String item = "Doggy Gucci bag";
		addItem(item);

		Set<String> items = shop.getItemsInStock();

		assertThat(items.contains(item)).isTrue();
	}

	@Test
	public void addItem_whenItemAdded_thenSendEmail() {
        String item = "Doggy Gucci bag";
        addItem(item);

        verify(emailServer, times(1)).sendMail(item);
	}

	@Test
    public void addItem_whenItemAdded_thenTriggerCallToStockService() {
        String item = "Doggy Gucci bag";

        mockServerClient.when(
                request()
                    .withBody(item)
                    .withPath("/items")
                    .withMethod("POST")
        ).respond(
                response()
                    .withBody(item)
                    .withStatusCode(201)
        );

        boolean success = shop.addItem(item);
        assertThat(success).isTrue();
    }
}
