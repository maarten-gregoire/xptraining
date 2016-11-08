package com.cegeka.spacebook;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Person> friends = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public Person(String name) throws Exception {
        if (name == "")
            throw new Exception("username can't be empty");
        else if (name == null)
            throw new Exception("username can't be null");
        else if (("").equals(name.trim()))
            throw new Exception("username can't be spaces");
        else
            this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person friend) throws Exception {
        if(friend == this)
            throw new Exception("friend can't be person");
        else
            friends.add(friend);

        if (!friend.getFriends().contains(this))
            friend.addFriend(this);
    }

    public void receiveMessage(Message message) throws Exception{
        if (friends.contains(message.getSender()))
            messages.add(message);
        else
            throw new Exception("Only friends can send messages");
    }

    public List<Message> getMessages() {
        return messages;
    }
}
