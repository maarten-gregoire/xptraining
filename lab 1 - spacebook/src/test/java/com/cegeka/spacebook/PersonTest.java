package com.cegeka.spacebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void Person_givenUsername_thenPersonCreated(){
        Person person = new Person("randomUsername");
        assertThat(person).isNotNull();
    }

    @Test (expected = IllegalArgumentException.class)
    public void Person_givenUsernameNull_thenThrowException(){
        new Person(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Person_givenUsernameEmpty_thenThrowException(){
        new Person("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void Person_givenUsernameSpaces_thenThrowException(){
        new Person("    ");
    }

    @Test
    public void Person_givenFriends_thenFriendAdded(){
        Person person = new Person("randomUsername");
        Person friend = new Person("friend");
        person.addFriend(friend);
        assertThat(person.getFriends()).contains(friend);
    }

    @Test
    public void Person_givenFriend_thenBidirectionalRelationshipIsAdded(){
        Person person = new Person("randomUsername");
        Person friend = new Person("friend");
        person.addFriend(friend);
        assertThat(friend.getFriends()).contains(person);
    }

    @Test (expected = Exception.class)
    public void Person_givenSelfAsFriend_thenThrowException(){
        Person person = new Person("randomUsername");
        person.addFriend(person);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Person_givenMessageFromNonFriend_thenThrowException(){
        Person person = new Person("randomUsername");
        Person nonFriend = new Person("nonFriend");
        Message message = new Message();
        message.setSender(nonFriend);
        person.receiveMessage(message);
    }

    @Test
    public void Person_givenMessageFromFriend_thenReceiveMessage(){
        Person person = new Person("randomUsername");
        Person friend = new Person("friend");
        person.addFriend(friend);
        Message message = new Message();
        message.setSender(friend);
        person.receiveMessage(message);
        assertThat(person.getMessages()).contains(message);
    }

    @Test
    public void Person_getReceivedMessages_giveMessages(){
        Person person = new Person("randomUsername");
        Person friend = new Person("friend");
        person.addFriend(friend);
        Message firstMessage = new Message();
        firstMessage.setSender(friend);
        Message secondMessage = new Message();
        secondMessage.setSender(friend);
        person.receiveMessage(firstMessage);
        person.receiveMessage(secondMessage);
        assertThat(person.getMessages()).contains(firstMessage).contains(secondMessage);
    }
}
