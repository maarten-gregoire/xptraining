package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by glennb on 8/11/2016.
 */
public class Person {

    private Set<Person> friends = new HashSet<>();
    private ArrayList<Message> messages = new ArrayList<>();

    public Person(String username) {
        if(username == null || username.isEmpty() || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addFriend(Person person) {
        if(person == this) {
            throw new IllegalArgumentException("Cannot befriend yourself");
        }
        friends.add(person);
        person.getFriends().add(this);
    }

    public void receiveMessage(Message message) {
        if (!getFriends().contains(message.getSender())) {
            throw new IllegalArgumentException("Sender is not a friend!");
        }

        getMessages().add(message);
    }
}
