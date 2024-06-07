package com.unimag.booking.client;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RabbitListeners(value = { @RabbitListener } )
public interface CarInventoryClient {

    @PostMapping(value = "/api/car-inventory/reserve", consumes = MediaType.APPLICATION_JSON_VALUE)
    void carReserve(@RequestBody String id,@RequestHeader("Authorization") String bearerToken);

}
