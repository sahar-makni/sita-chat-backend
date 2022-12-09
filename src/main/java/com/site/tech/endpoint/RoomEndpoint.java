package com.site.tech.endpoint;

import com.site.tech.entity.Room;
import com.site.tech.mapper.RoomMapper;
import com.site.tech.service.AuthService;
import com.site.tech.service.RoomService;
import com.site.tech.wrapper.response.RoomResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/rooms")
public class RoomEndpoint {

    private final RoomService roomService;
    private final AuthService authService;

    public RoomEndpoint(RoomService roomService, AuthService authService) {
        this.roomService = roomService;
        this.authService = authService;
    }

    @GET
    @Produces("application/json")
    @Transactional
    public Response getUserRooms(@HeaderParam("access-token") String accessToken) {
        Long userId = authService.getUserIdFromAccessToken(accessToken);
        List<Room> rooms = roomService.getUserRooms(userId);
        List<RoomResponse> userRoomsResponse = RoomMapper.INSTANCE.entityToResponse(rooms);
        return Response.status(Response.Status.OK).entity(userRoomsResponse).build();
    }
}
