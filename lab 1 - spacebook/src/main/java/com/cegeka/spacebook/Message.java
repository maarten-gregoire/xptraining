package com.cegeka.spacebook;

import java.time.Instant;

public class Message {

    public Instant getDate() {
        return Instant.EPOCH;
    }

    public Person getSender() {
        return new Person("Johan");
    }

    public String getBody() {
        return "I am your best friend!";
    }
}
