package com.example.hello.jakarta.hello;

import com.example.hello.jakarta.util.Logged;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    @Logged
    public String sayHello() {

        return "Hello World";
    }
}
