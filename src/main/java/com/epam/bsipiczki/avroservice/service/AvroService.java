package com.epam.bsipiczki.avroservice.service;

import avro.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AvroService {

    public Mono<Message> getAvroString() {
        var msg = new Message("avro");
        return Mono.just(msg);
    }

    public Message enrich(Message msg){
        return new Message(msg.getMsg()  + " enriched");
    }
}
