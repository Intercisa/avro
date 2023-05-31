package com.epam.bsipiczki.avroservice.controller;

import avro.Message;
import com.epam.bsipiczki.avroservice.producer.AvroProducer;
import com.epam.bsipiczki.avroservice.service.AvroService;
import com.epam.bsipiczki.avroservice.config.ProcessorTopic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AvroController {
   private final AvroService avroService;
   private final AvroProducer avroProducer;
   private final ProcessorTopic topic;


    public AvroController(AvroService avroService, AvroProducer avroProducer, ProcessorTopic topic) {
        this.avroService = avroService;
        this.avroProducer = avroProducer;
        this.topic = topic;
    }

    @GetMapping("/avro")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Message> getAvro() {
        return avroProducer.send(avroService.getAvroString(), topic.getWriteTopic());
    }
}
