package org.cegeka.petshop;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpMethod.POST;

public class Shop {

    private Set<String> itemList = new HashSet<String>();
    private MailClient mailClient;

    private RestTemplate restTemplate = new RestTemplate();

    public boolean addItem(String item) {
        itemList.add(item);
        mailClient.sendMail(item);
        return callREST(item);
    }

    public Set<String> getItemsInStock() {
        return itemList;
    }

    public boolean callREST(String item) {
        HttpEntity<String> request = new HttpEntity<>(item);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9002/additem", POST, request, String.class);
        int code = response.getStatusCodeValue();

        if (code == 200) {
            return true;
        }
        return false;
    }
}
