package org.cegeka.petshop;

import com.google.common.collect.ImmutableSet;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        return ImmutableSet.copyOf(itemList);
    }

    public boolean callREST(String item) {
        HttpEntity<String> request = new HttpEntity<>(item);

        //Map<String, String> urlVariables = new HashMap<>();

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9002/additem", HttpMethod.POST, request, String.class);//, urlVariables);
        int code = response.getStatusCodeValue();

        if(code == 200) {
            return true;
        }
        return false;
    }
}
