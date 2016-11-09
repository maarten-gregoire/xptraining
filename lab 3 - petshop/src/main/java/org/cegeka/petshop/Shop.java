package org.cegeka.petshop;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private Set<String> itemList = new HashSet<String>();
    private EmailServer emailServer = new EmailServer();
    private StockProvider stockProvider = new StockProvider();

    public boolean addItem(String item) {
        itemList.add(item);
        emailServer.sendMail(item);
        return stockProvider.addItemRemote(item);
    }

    public Set<String> getItemsInStock() {
        return ImmutableSet.copyOf(itemList);
    }
}
