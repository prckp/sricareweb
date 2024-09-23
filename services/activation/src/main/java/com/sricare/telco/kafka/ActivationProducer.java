package com.sricare.telco.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivationProducer {

    private final KafkaTemplate<String, ActivationConfirmation> kafkaTemplate;

    public void sendActivationConfirmation(ActivationConfirmation activationConfirmation) {
        log.info("Sending service activation confirmation");
        Message<ActivationConfirmation> message = MessageBuilder
                .withPayload(activationConfirmation)
                .setHeader(TOPIC, "activation-topic")
                .build();

        kafkaTemplate.send(message);
    }
}
