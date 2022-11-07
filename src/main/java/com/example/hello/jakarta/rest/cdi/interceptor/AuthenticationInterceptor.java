package com.example.hello.jakarta.rest.cdi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

@Interceptor
@Authentication
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 2)
public class AuthenticationInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {

        String parameters = Arrays.toString(ctx.getParameters());
        log.info("Intercepted call to bean with parameters {}", parameters);

        // additional code would be inserted here

        return ctx.proceed();
    }
}
