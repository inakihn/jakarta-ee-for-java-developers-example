package com.example.hello.jakarta.rest.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;

@SessionScoped
public class HelloWorldSession implements Serializable {

    private String message;

    private LocalDateTime localDateTime;

    @PostConstruct
    public void init() {
        this.message = "Hello world";
        this.localDateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
