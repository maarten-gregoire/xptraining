package com.cegeka.spacebook;

import java.time.Instant;

public class Message {

    private Instant date;
    private Person sender;
    private String body;

    public Message(Instant date, Person sender, String body) {
        this.date = date;
        this.sender = sender;
        this.body = body;
    }

    public Instant getDate() {
        return date;
    }

    public Person getSender() {
        return sender;
    }

    public String getBody() {
        return body;
    }
}
