package com.site.tech.service;

import com.site.tech.entity.Room;
import com.site.tech.entity.User;
import com.site.tech.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final UserService userService;
    private final RoomRepository roomRepository;

    public RoomService(UserService userService, RoomRepository roomRepository) {
        this.userService = userService;
        this.roomRepository = roomRepository;
    }

    public List<Room> getUserRooms(Long userId) {
        User user = userService.getUserById(userId);
        return roomRepository.findAllByUsersContains(user);
    }
}
