package com.site.tech.mapper;


import com.site.tech.entity.User;
import com.site.tech.wrapper.request.UserRequestWrapper;
import com.site.tech.wrapper.response.UserResponseWrapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestToEntity(UserRequestWrapper dto);

    UserResponseWrapper entityToResponse(User user);
}
