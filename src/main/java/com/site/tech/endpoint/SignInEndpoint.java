package com.site.tech.endpoint;

import com.site.tech.entity.User;
import com.site.tech.mapper.UserMapper;
import com.site.tech.service.UserService;
import com.site.tech.wrapper.request.SignInRequest;
import com.site.tech.wrapper.response.SignInResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Service
@Path("/signin")
public class SignInEndpoint {

    private final UserService userService;

    public SignInEndpoint(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response signIn(@Valid @RequestBody SignInRequest signInRequest) {
        User user = userService.trySignIn(signInRequest);
        SignInResponse signInResponse = UserMapper.INSTANCE.entityToSignInResponse(user);
        return Response.status(Response.Status.OK).entity( signInResponse).build();
    }


}
