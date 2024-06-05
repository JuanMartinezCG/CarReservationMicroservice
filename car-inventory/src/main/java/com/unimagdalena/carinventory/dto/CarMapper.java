package com.unimagdalena.carinventory.dto;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.unimagdalena.carinventory.entitys.Car;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @Mapping(target = "id", expression = "java(null)")
    Car createCarDtoToCar(CreateCarDto createCarDto);

    CarReserveResponse carToCarReserveResponse(Car car);

    ResponseCarDto carToResponseCarDto(Car car);

    @IterableMapping(elementTargetType = ResponseCarDto.class)
    List<ResponseCarDto> carsToCarsDto(List<Car> cars);
} 