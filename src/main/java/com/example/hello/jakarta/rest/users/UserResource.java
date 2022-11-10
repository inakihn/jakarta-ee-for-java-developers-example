package com.example.hello.jakarta.rest.users;

import com.example.hello.jakarta.util.Logged;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@Path("/users")
@Singleton
public class UserResource {

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);


    /**
     * Parameters can be sent to Jakarta RESTful like this
     * URI path (or path parameter): Using @PathParam annotation.
     * Query: Using @QueryParam annotation.
     * Header: Using @HeaderParam annotation.
     * Form: Using @FormParam annotation.
     * Cookie: Using @CookieParam annotation.
     * Matrix: Using @MatrixParam annotation.
     */

    @Inject
    private UserInMemDatasource userInMemDatasource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Logged
    public Response list() throws JsonProcessingException {
        log.debug("a debug message");
        log.info("an info message");
        return Response.ok(userInMemDatasource.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(User user) {
        user = userInMemDatasource.persist(user);
        return Response
                .created(URI.create(String.format("/users/%s", user.getId())))
                .build();
    }
}
