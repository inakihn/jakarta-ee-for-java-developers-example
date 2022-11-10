package com.example.hello.jakarta.rest.objectmapper;

import com.example.hello.jakarta.util.Logged;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/objectmapper")
@Singleton
public class ObjectMapperExampleController {

    @Inject
    private ObjectMapper objectMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public Response list() throws JsonProcessingException {
        ObjectMapper mapper = objectMapper;
        String json = "{\"name\":\"inaki\", \"age\":\"37\"}";
        Map<String, String> map = mapper.readValue(json, Map.class);
        return Response.ok(map).build();
    }
}
