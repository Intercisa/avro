package com.epam.bsipiczki.avroservice.config;

import avro.Message;
import com.epam.bsipiczki.avroservice.service.AvroService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class AvroProcessor {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public Function<Flux<Message>, Flux<Message>> processAvro(AvroService avroService) {
        return avroFlux -> avroFlux.map(avroService::enrich);
    }
}
