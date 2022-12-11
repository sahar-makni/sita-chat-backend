package com.site.tech.service;

import com.site.tech.entity.Room;
import com.site.tech.entity.User;
import com.site.tech.exception.BusinessException;
import com.site.tech.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MessageServiceTest {

    MessageService service;
    @Mock
    private RoomService roomService;
    @Mock
    private UserService userService;
    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    void setup() {
        service = new MessageService(roomService, userService, messageRepository);
    }

    @Test
    void assertUserInRoom_throws_if_test_fails() {
        Room room = new Room();
        User user = new User();
        user.setRooms(new ArrayList<>());
        assertThrows(BusinessException.class, () -> {
            service.assertUserInRoom(user, room);
        });
    }
    @Test
    void assertUserInRoom_DO_NOT_throw_if_test_success() {
        Room room = new Room();
        User user = new User();
        user.setRooms(new ArrayList<>());
        user.getRooms().add(room);
        service.assertUserInRoom(user, room);
    }
}