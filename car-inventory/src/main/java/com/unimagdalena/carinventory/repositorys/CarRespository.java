package com.unimagdalena.carinventory.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unimagdalena.carinventory.entitys.Car;


public interface CarRespository extends JpaRepository<Car, String> {

    @Query("SELECT c FROM Car c WHERE c.available = true")
    List<Car> findAllAvailables();
    
}
