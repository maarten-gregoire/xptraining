package stub;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RunWith(MockitoJUnitRunner.class)
public class TimeProviderTest {

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this, 8080);
    private MockServerClient mockServerClient;

    @InjectMocks
    private TimeProvider timeProvider;

    @Test
    public void afternoon() throws Exception {
        mockServerClient.when(
                request()
                        .withBody("{\"time\": \"yes please\"}")
                        .withPath("/gettime")
                        .withMethod("POST")
                        .withQueryStringParameter("zone", "europe")
        )
                .respond(response()
                        .withBody("afternoon")
                        .withStatusCode(200));

        boolean isAfternoon = timeProvider.isAfternoon();

        assertThat(isAfternoon).isTrue();
    }

    @Test
    public void morning() throws Exception {
        mockServerClient.when(
                request()
                        .withBody("{\"time\": \"yes please\"}")
                        .withPath("/gettime")
                        .withMethod("POST")
                        .withQueryStringParameter("zone", "europe"))
                .respond(response()
                        .withBody("morning")
                        .withStatusCode(200));

        boolean isAfternoon = timeProvider.isAfternoon();

        assertThat(isAfternoon).isFalse();
    }
}