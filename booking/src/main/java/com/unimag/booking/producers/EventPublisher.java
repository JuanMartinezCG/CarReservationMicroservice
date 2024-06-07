package com.unimag.booking.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimag.booking.event.CustomEvent;

@Service
public class EventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishEvent(CustomEvent event) {
        rabbitTemplate.convertAndSend("exchangeName", "routingKey", event);
    }
}

