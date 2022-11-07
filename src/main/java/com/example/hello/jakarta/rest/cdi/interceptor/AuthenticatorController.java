package com.example.hello.jakarta.rest.cdi.interceptor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/authenticate")
@Singleton
public class AuthenticatorController {

    @Inject
    private AuthenticationDatasource authenticationDatasource;

    @Inject
    private SecuredService securedService;

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response appendMessage(@QueryParam("username") String username, @QueryParam("password") String password) {

        if (!authenticationDatasource.validate(username, password)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "forbidden");

            return Response.status(Response.Status.FORBIDDEN)
                    .entity(errorResponse)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }

        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("message", securedService.generateText(username));
        return Response.ok(successResponse)
                .build();
    }


}
