package com.unimag.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.unimag.booking.config.FeignClientConfig;
import com.unimag.booking.dto.carInventory.CarReserveResponse;


@FeignClient(name = "car-inventory", url = "http://localhost:8080", configuration = FeignClientConfig.class )
public interface CarInventoryClient {

    @PostMapping(value = "/api/car-inventory/reserve", consumes = MediaType.APPLICATION_JSON_VALUE)
    CarReserveResponse carReserve(@RequestBody String id,@RequestHeader("Authorization") String bearerToken);

}
