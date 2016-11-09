package org.cegeka.petshop;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

public class StockProvider {

    private RestTemplate restTemplate = new RestTemplate();

    public boolean addItemRemote(String item) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity(item, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/items", POST, request, String.class);

        if (response.getStatusCodeValue() == 201) {
            return true;
        }
        return false;
    }
}
