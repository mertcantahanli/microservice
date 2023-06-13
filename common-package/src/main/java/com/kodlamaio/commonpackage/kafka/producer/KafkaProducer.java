package com.kodlamaio.commonpackage.kafka.producer;

import com.kodlamaio.commonpackage.events.Event;
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
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public <T extends Event> void sendMessage(T event, String topic) { //event turu classlar almasi icin ozellestirdik
        log.info(String.format("%s events => %s", topic, event.toString()));
        Message<T> message = MessageBuilder
                .withPayload(event)//mesajın içeriğini(event) belirlemek için kullanılır.
                .setHeader(KafkaHeaders.TOPIC, topic)//mesajın hedeflendiği konuyu başlık olarak ayarlar
                .build();

        kafkaTemplate.send(message);
    }
}