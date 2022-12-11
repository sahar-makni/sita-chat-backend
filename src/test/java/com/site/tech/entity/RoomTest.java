package com.site.tech.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RoomTest {

    @Test
    void getLastMessageTime_should_return_null_when_roomMessages_is_empty() {
        // GIVEN
        Room room = new Room();
        room.setRoomMessages(new ArrayList<>());
        // WHEN
        Date lastMessageTime = room.getLastMessageTime();
        // THEN
        assertNull(lastMessageTime);
    }

    @Test
    void getLastMessageTime_should_return_the_date_of_message_when_roomMessages_has_one_message() {
        // GIVEN
        Room room = new Room();
        ArrayList<Message> roomMessages = new ArrayList<>();
        Date sendDate = new Date();
        roomMessages.add(new Message(1L, room, new User(), "hello from test", sendDate));
        room.setRoomMessages(roomMessages);
        // WHEN
        Date lastMessageTime = room.getLastMessageTime();
        // THEN
        assertEquals(lastMessageTime, sendDate);
    }

    @Test
    void getLastMessageTime_should_return_the_date_latest_date_of_message_when_roomMessages_has_many_messages() {
        // GIVEN
        Room room = new Room();
        ArrayList<Message> roomMessages = new ArrayList<>();
        Date sendDateOld = new Date(1_600_000_000L);
        Date sendDateNew = new Date(1_670_000_000L);
        roomMessages.add(new Message(1L, room, new User(), "hello from test old", sendDateOld));
        roomMessages.add(new Message(2L, room, new User(), "hello from test new", sendDateNew));
        room.setRoomMessages(roomMessages);
        // WHEN
        Date lastMessageTime = room.getLastMessageTime();
        // THEN
        assertEquals(lastMessageTime, sendDateNew);

    }
}