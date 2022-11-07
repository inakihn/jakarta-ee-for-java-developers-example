package com.example.hello.jakarta.rest.cdi.interceptor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecuredService {

    @Authentication
    public String generateText(String username) {
        return "Welcome " + username;
    }
}