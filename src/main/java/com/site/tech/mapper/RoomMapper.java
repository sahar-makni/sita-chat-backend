package com.site.tech.mapper;


import com.site.tech.entity.Room;
import com.site.tech.wrapper.response.RoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface RoomMapper {

    @Mapping(source = "users", target = "userIds")
    RoomResponse entityToResponse(Room room);

    List<RoomResponse> entityToResponse(List<Room> rooms);

    default Long entityToId(Room room) {
        return room.getId();
    }

}
