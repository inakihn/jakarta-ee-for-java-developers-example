package com.example.hello.jakarta.rest.cdi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Objects;

import static java.lang.String.format;

@Auditoring
@Interceptor
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 1)
public class AuditoringInterceptor implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(AuditoringInterceptor.class);

    private static final String PATTERN_AUDIT = "username:%s ; class called:%s ; method called:%s";

    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {

        String username = (String) invocationContext.getParameters()[0];
        String className = invocationContext.getTarget().getClass().getName();
        String methodName = invocationContext.getMethod().getName();

        log.info("{}", format(PATTERN_AUDIT, Objects.requireNonNullElse(username, "anonymous"), className, methodName));

        return invocationContext.proceed();
    }


}
