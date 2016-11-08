package com.cegeka.spacebook;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void Person_givenUsername_thenPersonCreated() {
        Person person = new Person("randomUsername");

        assertThat(person).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenUsername_thenIsNotNull() {
        Person person = new Person(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenUsername_thenIsNotEmpty() {
        Person person = new Person("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenUsername_thenIsNotSpaces() {
        Person person = new Person("       ");
    }

    @Test
    public void Person_givenListOfFriends_thenHasFriends() {
        Person person = new Person("randomUsername");
        Set<Person> friends = person.getFriends();
        assertThat(friends).isNotNull();
    }

    @Test
    public void Person_givenFriend_thenHasBidirectionalRelationship() {
        Person person1 = new Person("Henry the First");
        Person person2 = new Person("Henry the Second");

        person1.addFriend(person2);

        assertThat(person1.getFriends()).contains(person2);
        assertThat(person2.getFriends()).contains(person1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenSelf_thenCannotAddFriend() {
        Person person = new Person("randomUsername");
        person.addFriend(person);
    }

    @Test
    public void Person_givenMessageFromFriend_thenCanReceive() {
        Person person = new Person("Jim");
        Person friend = new Person("Joe");
        person.addFriend(friend);

        Message message1 = new Message(Instant.EPOCH, friend, "Seperated");
        Message message2 = new Message(Instant.EPOCH, friend, "Messages");

        person.receiveMessage(message1);
        person.receiveMessage(message2);

        List<Message> messages = person.getMessages();
        assertThat(messages).containsExactly(message1, message2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Person_givenMessageFromStranger_thenCannotReceive() {
        Person person = new Person("Jim");
        Person stranger = new Person("Joe");
        Message message = new Message(Instant.EPOCH, stranger, "Hello stranger.");

        person.receiveMessage(message);
    }
}
