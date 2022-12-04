package com.site.tech.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

@Service
@Path("/users")
public class UserService {

    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello from Spring";
    }
}