package com.sricare.telco.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaActivationTopicConfig {

    @Bean
    public NewTopic activationTopic() {
        return TopicBuilder
                .name("activation-topic")
                .build();
    }
}
