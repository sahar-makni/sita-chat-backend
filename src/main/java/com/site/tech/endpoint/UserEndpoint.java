package com.site.tech.endpoint;

import com.site.tech.entity.User;
import com.site.tech.mapper.UserMapper;
import com.site.tech.service.UserService;
import com.site.tech.wrapper.request.UserRequestWrapper;
import com.site.tech.wrapper.response.UserResponseWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Service
@Path("/users")
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addUser(@Valid @RequestBody UserRequestWrapper userRequestWrapper) {
        User user = userService.createUser(userRequestWrapper);
        UserResponseWrapper userResponseWrapper = UserMapper.INSTANCE.entityToResponse(user);
        return Response.status(Response.Status.CREATED).entity(userResponseWrapper).build();
    }
}