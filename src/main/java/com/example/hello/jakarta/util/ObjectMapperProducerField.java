package com.example.hello.jakarta.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.inject.Produces;

public class ObjectMapperProducerField {

    @Produces
    private ObjectMapper objectMapper;

    public ObjectMapperProducerField() {
        this.objectMapper = new ObjectMapper();
    }
}
