package com.unimagdalena.carinventory.api;

import org.springframework.web.bind.annotation.RestController;

import com.unimagdalena.carinventory.dto.CarReserveResponse;
import com.unimagdalena.carinventory.dto.CreateCarDto;
import com.unimagdalena.carinventory.dto.ResponseCarDto;
import com.unimagdalena.carinventory.services.CarServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;







@RestController
@RequestMapping("api/car-inventory")
@AllArgsConstructor
public class CarController {

    private final CarServiceImpl carService;
    
    @GetMapping("/availables")
    public ResponseEntity<List<ResponseCarDto>> listarDisponibles() {
        return ResponseEntity.ok().body(this.carService.listAvailable());
    }

    @PostMapping("")
    public ResponseEntity<ResponseCarDto> crear(@RequestBody CreateCarDto createCarDto) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.carService.create(createCarDto));
    }

    @PostMapping("/reserve")
    public ResponseEntity<CarReserveResponse> postMethodName(@RequestBody String id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.carService.reserveCar(id));
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnCar(@RequestBody String id) {
        this.carService.returnCar(id);
        return ResponseEntity.ok().body("El auto se ha devuelto correctamente");
    }
    
    
    
    
}
