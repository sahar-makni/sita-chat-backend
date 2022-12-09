package com.site.tech.endpoint;

import com.site.tech.entity.Room;
import com.site.tech.mapper.RoomMapper;
import com.site.tech.service.RoomService;
import com.site.tech.wrapper.response.RoomResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/users/{userId}/rooms")
public class RoomEndpoint {

    private final RoomService roomService;

    public RoomEndpoint(RoomService roomService) {
        this.roomService = roomService;
    }

    @GET
    @Produces("application/json")
    @Transactional
    public Response getUserRooms(@PathParam("userId") Long userId) {
        List<Room> rooms = roomService.getUserRooms(userId);
        List<RoomResponse> userRoomsResponse = RoomMapper.INSTANCE.entityToResponse(rooms);
        return Response.status(Response.Status.OK).entity(userRoomsResponse).build();
    }
}
