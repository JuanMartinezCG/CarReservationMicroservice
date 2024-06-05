package com.unimag.booking.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimag.booking.dto.CreateBookingDto;
import com.unimag.booking.dto.ResponseBookingDto;
import com.unimag.booking.exceptions.carInventory.CarReserveException;
import com.unimag.booking.services.BookingServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("api/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingService;
    
    @PostMapping("")
    public ResponseEntity<ResponseBookingDto> postMethodName(@RequestBody CreateBookingDto createBookingDto, @RequestHeader("Authorization") String authorizationHeader) {
        try { 
            return ResponseEntity.status(HttpStatus.CREATED).body(this.bookingService.createBooking(createBookingDto,authorizationHeader));
        } catch (Exception e) {
            throw new CarReserveException("No se ha podido reservar el auto, verifique que esté disponible" );
        }    
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBookingDto> getBookingById(@PathVariable String id) {

        try{
            ResponseBookingDto booking = this.bookingService.getBookingById(id);
            return ResponseEntity.ok().body(booking);
        } catch( Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }
    
    
}
