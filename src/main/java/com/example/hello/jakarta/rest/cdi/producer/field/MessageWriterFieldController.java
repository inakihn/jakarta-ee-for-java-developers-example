package com.example.hello.jakarta.rest.cdi.producer.field;

import com.example.hello.jakarta.rest.cdi.producer.method.MessageWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Objects;

@Path("/messages/field")
@Singleton
public class MessageWriterFieldController {

    @Inject
    @MessageField
    private MessageWriter messageWriter;

    @GET
    @Path("/append")
    @Produces(MediaType.APPLICATION_JSON)
    public Response appendMessage(@QueryParam("message") String message) throws IOException {

        if (Objects.nonNull(message) && !message.isEmpty()) {
            messageWriter.add(message);
        }

        return Response.ok(messageWriter.read())
                .build();
    }

    @GET
    @Path("/clean")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clean() {
        messageWriter.clean();

        return Response.ok()
                .build();
    }


}