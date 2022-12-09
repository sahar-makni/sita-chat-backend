package com.site.tech.mapper;


import com.site.tech.entity.Room;
import com.site.tech.wrapper.response.RoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UserMapper.class})
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "users", target = "userIds")
    RoomResponse entityToResponse(Room room);

    List<RoomResponse> entityToResponse(List<Room> rooms);

}
