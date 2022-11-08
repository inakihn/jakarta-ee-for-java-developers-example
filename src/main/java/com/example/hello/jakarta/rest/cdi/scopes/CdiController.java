package com.example.hello.jakarta.rest.cdi.scopes;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/cdi")
@Singleton
public class CdiController {

    @Inject
    private HelloWorldRequest helloWorldRequest;

    @Inject
    private HelloWorldSession helloWorldSession;

    @GET
    @Path("/request")
    @Produces("application/json")
    public HelloWorldRequest getHelloWorldRequest() {
        return helloWorldRequest;
    }

    @GET
    @Path("/session")
    @Produces("application/json")
    public HelloWorldSession getHelloWorldSession() {
        return helloWorldSession;
    }


}
