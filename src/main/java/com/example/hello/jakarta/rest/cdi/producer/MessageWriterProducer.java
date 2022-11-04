package com.example.hello.jakarta.rest.cdi.producer;

import javax.enterprise.inject.Produces;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class MessageWriterProducer {

    private static final Logger log = Logger.getLogger(MessageWriterProducer.class.getName());

    private static final String HOME_PATH =  System.getProperty("user.home") + "/tmp/";

    private static final String NAME_PATTERN = "MESSAGE_%d.txt";

    @Produces
    @Message
    public MessageWriter build() {
        String fileName = String.format(NAME_PATTERN, Timestamp.valueOf(LocalDateTime.now()).getTime());
        log.info(() -> String.format("Creating file message: %s", HOME_PATH + fileName));

        return new MessageWriter(HOME_PATH + fileName);
    }

}
