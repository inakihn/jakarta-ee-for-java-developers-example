package com.example.hello.jakarta.rest.cdi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
