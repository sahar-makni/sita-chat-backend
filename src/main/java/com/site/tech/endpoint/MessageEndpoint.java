package com.site.tech.endpoint;

import com.site.tech.entity.Message;
import com.site.tech.mapper.MessageMapper;
import com.site.tech.service.MessageService;
import com.site.tech.wrapper.request.AppendMessageRequest;
import com.site.tech.wrapper.response.MessageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
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
            @HeaderParam("access-token") String accessToken,
            @PathParam("roomId") Long roomId) {
        // TODO : Paginate this WS
        Long userId = getUserIdFromAccessToken(accessToken);
        List<Message> messages = messageService.getRoomMessages(userId, roomId);
        List<MessageResponse> messageResponses = MessageMapper.INSTANCE.entityToResponse(messages);
        return Response.status(Response.Status.OK).entity(messageResponses).build();
    }

    @POST
    @Produces("application/json")
    @Transactional
    public Response appendMessage(
             @HeaderParam("access-token") String accessToken,
            @PathParam("roomId") Long roomId,
            @Valid @RequestBody AppendMessageRequest appendMessageRequest
    ){
        Long userId = getUserIdFromAccessToken(accessToken);
        messageService.appendMessage(userId, roomId, appendMessageRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    private Long getUserIdFromAccessToken(String accessToken) {
        // since the access token is the user ID (du to time limitation, I was not able to implement the
        // oAuth2 protocol
        return Long.parseLong(accessToken);
    }
}
