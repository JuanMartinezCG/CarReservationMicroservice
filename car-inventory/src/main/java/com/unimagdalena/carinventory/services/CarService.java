package com.unimagdalena.carinventory.services;

import java.util.List;

import com.unimagdalena.carinventory.dto.CarReserveResponse;
import com.unimagdalena.carinventory.dto.CreateCarDto;
import com.unimagdalena.carinventory.dto.ResponseCarDto;

import jakarta.ws.rs.NotFoundException;

public interface CarService{

    ResponseCarDto create(CreateCarDto createCarDto);
    List<ResponseCarDto> listAvailable();
    CarReserveResponse reserveCar(String id) throws NotFoundException;
    void returnCar(String id);

}
