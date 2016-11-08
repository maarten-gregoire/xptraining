package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Person> friends = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public Person(String name){
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("username can't be empty");
        else
            this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person friend){
        if(friend == this)
            throw new IllegalArgumentException("friend can't be person");
        else
            friends.add(friend);

        if (!friend.getFriends().contains(this))
            friend.addFriend(this);
    }

    public void receiveMessage(Message message){
        if (friends.contains(message.getSender()))
            messages.add(message);
        else
            throw new IllegalArgumentException("Only friends can send messages");
    }

    public List<Message> getMessages() {
        return messages;
    }
}
