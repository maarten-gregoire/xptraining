package com.cegeka.spacebook;

import java.util.Date;

/**
 * Created by maarteng on 8/11/2016.
 */
public class Message {
    private Date date;
    private Person sender;
    private String body;

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getSender() {
        return sender;
    }
}
