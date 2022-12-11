package com.site.tech.endpoint;

import com.site.tech.entity.User;
import com.site.tech.mapper.UserMapper;
import com.site.tech.service.UserService;
import com.site.tech.wrapper.request.ChangePasswordRequest;
import com.site.tech.wrapper.request.PatchUserRequest;
import com.site.tech.wrapper.request.UserRequest;
import com.site.tech.wrapper.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Service
@Path("/users")
public class UserResource {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserResource(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @POST
    @Produces("application/json")
    public Response addUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        UserResponse userResponse = userMapper.entityToResponse(user);
        return Response.status(Response.Status.CREATED).entity(userResponse).build();
    }

    @GET
    @Path(("/{id}"))
    @Produces("application/json")
    public Response getUserById(@PathParam("id") Long id) {
        User user = userService.getUserById(id);

        UserResponse userWrapper = userMapper.entityToResponse(user);

        return Response.status(Response.Status.OK).entity(userWrapper).build();
    }

    @PATCH
    @Path(("/{id}"))
    @Produces("application/json")
    public Response patchUserById(@PathParam("id") Long id, @Valid @RequestBody PatchUserRequest patchUserRequest) {
        User user = userService.patchUserById(id, patchUserRequest);

        UserResponse userWrapper = userMapper.entityToResponse(user);

        return Response.status(Response.Status.OK).entity(userWrapper).build();
    }

    @POST
    @Path("/{id}/changePassword")
    @Produces("application/json")
    public Response changePassword(@PathParam("id") Long id, @Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        userService.changePassword(id, changePasswordRequest);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}