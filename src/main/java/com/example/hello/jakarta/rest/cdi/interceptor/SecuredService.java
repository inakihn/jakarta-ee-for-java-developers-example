package com.example.hello.jakarta.rest.cdi.interceptor;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecuredService {

    @Authentication
    @Auditoring
    public String generateText(String username) {
        return "Welcome " + username;
    }
}
