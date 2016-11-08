package com.cegeka.spacebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class MessageTest {

    @Test
    public void Message_givenReceivedMessage_thenMessageHasDate() {
        Message message = new Message();
        assertThat(message.getDate()).isNotNull();
    }

    @Test
    public void Message_givenReceivedMessage_thenMessageHasSender() {
        Message message = new Message();
        assertThat(message.getSender()).isNotNull();
    }

    @Test
    public void Message_givenReceivedMessage_thenMessageHasBody() {
        Message message = new Message();
        assertThat(message.getBody()).isNotNull();
    }
}
