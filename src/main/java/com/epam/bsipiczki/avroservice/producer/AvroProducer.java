package com.epam.bsipiczki.avroservice.producer;

import avro.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AvroProducer {
    private final KafkaTemplate<Message, Message> producer;

    public AvroProducer(KafkaTemplate<Message, Message> producer) {
        this.producer = producer;
    }

    public Mono<Message> send(Mono<Message> message, String topic) {
        return message.doOnNext(msg -> producer.send(topic, msg));
    }
}
