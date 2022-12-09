package com.site.tech.repository;

import com.site.tech.entity.Room;
import com.site.tech.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAllByUsersContains(User user);
}
