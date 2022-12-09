package com.site.tech.endpoint;

import com.site.tech.entity.Message;
import com.site.tech.mapper.MessageMapper;
import com.site.tech.service.MessageService;
import com.site.tech.wrapper.response.MessageResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/rooms/{roomId}/messages")
public class MessageEndpoint {

    private final MessageService messageService;

    public MessageEndpoint(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Produces("application/json")
    @Transactional
    public Response getRoomMessages(
//            @HeaderParam("access-token") String accessToken,
            @PathParam("roomId") Long roomId) {
        // FIXME:  using the access token to identify the user
        //    Check if the user is a member in the room
        // TODO : Paginate this WS
        List<Message> messages = messageService.getRoomMessages(roomId);
        List<MessageResponse> messageResponses = MessageMapper.INSTANCE.entityToResponse(messages);
        return Response.status(Response.Status.OK).entity(messageResponses).build();
    }
}
