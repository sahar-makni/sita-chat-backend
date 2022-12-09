package com.site.tech.mapper;


import com.site.tech.entity.Message;
import com.site.tech.wrapper.response.MessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UserMapper.class, RoomMapper.class})
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    //    @Mapping(source = "id", target = "id")
    @Mapping(source = "sender", target = "senderId")
    @Mapping(source = "room", target = "roomId")
    MessageResponse entityToResponse(Message message);

    List<MessageResponse> entityToResponse(List<Message> messages);

}
