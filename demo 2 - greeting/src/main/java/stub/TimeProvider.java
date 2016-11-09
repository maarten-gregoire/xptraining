package stub;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

public class TimeProvider {

    private RestTemplate restTemplate = new RestTemplate();

    public boolean isAfternoon() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity("{\"time\": \"yes please\"}", httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/gettime?zone={timezone}", POST, request, String.class, "europe");

        String body = response.getBody();
        if (body.equals("afternoon")) {
            return true;
        }
        return false;
    }
}
