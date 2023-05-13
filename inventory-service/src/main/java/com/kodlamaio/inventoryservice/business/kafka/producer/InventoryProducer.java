package com.kodlamaio.inventoryservice.business.kafka.producer;

import com.kodlamaio.commonpackage.event.inventory.BrandDeletedEvent;
import com.kodlamaio.commonpackage.event.inventory.CarCreatedEvent;
import com.kodlamaio.commonpackage.event.inventory.CarDeletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    public void kafkaMessage(Object event, String topic) {
        log.info(String.format("%s event => %s", topic, event.toString()));
        Message<Object> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
    public void sendMessage(CarCreatedEvent event) {
        kafkaMessage(event,"car-created");
    }

    public void sendMessage(CarDeletedEvent event) {
        kafkaMessage(event,"car-deleted");
    }

    public void sendMessage(BrandDeletedEvent event) {
        kafkaMessage(event,"brand-deleted");
    }


}
