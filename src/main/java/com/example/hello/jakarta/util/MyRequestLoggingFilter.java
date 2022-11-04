package com.example.hello.jakarta.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Logged
@Provider
public class MyRequestLoggingFilter implements ContainerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(MyRequestLoggingFilter.class);


    @Override
    public void filter(final ContainerRequestContext requestContext) {
        // example to log the invoked path
        final String invokedPath = requestContext.getUriInfo().getPath();
        log.info("Request to path {} has been made", invokedPath);
    }
}
