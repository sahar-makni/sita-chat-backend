package com.site.tech.repository;

import com.site.tech.entity.Message;
import com.site.tech.entity.Room;
import com.site.tech.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAllByRoom(Room room);
}
