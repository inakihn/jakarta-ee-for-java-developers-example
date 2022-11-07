package com.example.hello.jakarta.rest.hello;

import com.example.hello.jakarta.util.Logged;
import jakarta.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
