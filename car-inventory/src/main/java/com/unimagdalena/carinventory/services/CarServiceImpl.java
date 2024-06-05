package com.unimagdalena.carinventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unimagdalena.carinventory.dto.CreateCarDto;
import com.unimagdalena.carinventory.dto.ResponseCarDto;
import com.unimagdalena.carinventory.entitys.Car;
import com.unimagdalena.carinventory.repositorys.CarRespository;

import jakarta.ws.rs.NotFoundException;

import com.unimagdalena.carinventory.dto.CarMapperImpl;
import com.unimagdalena.carinventory.dto.CarReserveResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRespository carRespository;
    private final CarMapperImpl carMapperImpl;

    @Override
    public ResponseCarDto create(CreateCarDto createCarDto) {
       Car car = this.carMapperImpl.createCarDtoToCar(createCarDto);
       Car savedCar = this.carRespository.save(car);
       return this.carMapperImpl.carToResponseCarDto(savedCar);
    }

    @Override
    public List<ResponseCarDto> listAvailable() {
        return this.carMapperImpl.carsToCarsDto(this.carRespository.findAllAvailables());
    }

    @Override
    public CarReserveResponse reserveCar(String id) throws NotFoundException {
        Optional<Car> car = this.carRespository.findById(id);
        
        if(!car.isPresent() || car.get().getAvailable() == false) throw new NotFoundException();

        car.get().setAvailable(false);
        this.carRespository.save(car.get());
        return this.carMapperImpl.carToCarReserveResponse(car.get());

    }

    @Override
    public void returnCar(String id) {
        Optional<Car> car = this.carRespository.findById(id);
        
        if(!car.isPresent()) throw new NotFoundException();

        car.get().setAvailable(true);
        this.carRespository.save(car.get());
    }


}
