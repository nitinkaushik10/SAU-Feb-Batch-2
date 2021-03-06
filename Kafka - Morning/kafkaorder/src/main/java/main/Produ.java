package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import model.Order;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Produ {

    @Autowired
    private KafkaTemplate<String, String> producerKafkaTemplate;

    public void createOrder(Order order) {
        String topicName = "createOrder";
        producerKafkaTemplate.send(topicName, order.toString());
        log.info("########## Kafka Order Created by Producer, msg = {}", order.toString());
    }

    public void shipOrder(Order order) {
        String topicName = "shipOrder";
        producerKafkaTemplate.send(topicName, order.toString());
        log.info("Kafka Order Shipped by Producer , msg = {}", order.toString());
    }

}