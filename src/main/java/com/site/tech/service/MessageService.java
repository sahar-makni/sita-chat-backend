package com.site.tech.service;

import com.site.tech.entity.Message;
import com.site.tech.entity.Room;
import com.site.tech.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final RoomService roomService;
    private final MessageRepository messageRepository;

    public MessageService(RoomService roomService, MessageRepository messageRepository) {
        this.roomService = roomService;
        this.messageRepository = messageRepository;
    }

    public List<Message> getRoomMessages(Long roomId) {
        Room room = roomService.getRoomById(roomId);
        return messageRepository.findAllByRoom(room);
    }
}
