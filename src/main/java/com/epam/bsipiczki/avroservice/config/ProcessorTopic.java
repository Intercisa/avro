package com.epam.bsipiczki.avroservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import java.util.Objects;

@ConfigurationProperties("app.topic")
@ConfigurationPropertiesScan
@Component
public class ProcessorTopic {
    private String writeTopic;

    public String getWriteTopic() {
        return writeTopic;
    }

    public void setWriteTopic(String writeTopic) {
        this.writeTopic = writeTopic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessorTopic that = (ProcessorTopic) o;
        return Objects.equals(writeTopic, that.writeTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(writeTopic);
    }
}
