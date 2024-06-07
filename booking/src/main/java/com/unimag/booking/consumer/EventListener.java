package com.unimag.booking.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.unimag.booking.event.CustomEvent;

@Service
public class EventListener {
    @RabbitListener(queues = "queueName")
    public void handleEvent(CustomEvent event) {
        // Lógica para manejar el evento
        System.out.println("Evento recibido: " + event.getMessage());
    }
}

