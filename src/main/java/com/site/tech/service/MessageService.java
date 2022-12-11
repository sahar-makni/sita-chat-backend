package com.site.tech.service;

import com.site.tech.entity.Message;
import com.site.tech.entity.Room;
import com.site.tech.entity.User;
import com.site.tech.exception.BusinessException;
import com.site.tech.repository.MessageRepository;
import com.site.tech.wrapper.request.AppendMessageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    private final RoomService roomService;
    private final UserService userService;
    private final MessageRepository messageRepository;

    public MessageService(RoomService roomService, UserService userService, MessageRepository messageRepository) {
        this.roomService = roomService;
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    public List<Message> getRoomMessages(Long userId, Long roomId) {
        User user = userService.getUserById(userId);
        Room room = roomService.getRoomById(roomId);
        assertUserInRoom(user, room);
        return messageRepository.findAllByRoom(room);
    }

    public void appendMessage(Long userId, Long roomId, AppendMessageRequest appendMessageRequest) {
        Room room = roomService.getRoomById(roomId);
        User user = userService.getUserById(userId);
        assertUserInRoom(user, room);
        Message message = new Message();
        message.setRoom(room);
        message.setText(appendMessageRequest.getText());
        message.setSender(user);
        message.setSendDate(new Date());
        messageRepository.save(message);
    }

    public void assertUserInRoom(User user, Room room){
        if (!user.getRooms().contains(room)) {
            throw new BusinessException("404 NOT FOUND - Room not found");
        }
    }
}
