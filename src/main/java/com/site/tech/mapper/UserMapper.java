package com.site.tech.mapper;


import com.site.tech.entity.User;
import com.site.tech.wrapper.response.SignInResponse;
import com.site.tech.wrapper.request.UserRequest;
import com.site.tech.wrapper.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestToEntity(UserRequest dto);

    UserResponse entityToResponse(User user);

    default Long entityToId(User user) {
        return user.getId();
    }



    // FIXME : this is not a good idea to use the id as access token alternative.
    //   will try to improve it later if there is time (hopefully)
    @Mapping(source = "id", target = "accessToken")
    SignInResponse entityToSignInResponse(User user);
}
