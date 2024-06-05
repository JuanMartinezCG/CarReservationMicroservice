package com.unimag.booking.services;

import org.springframework.web.bind.annotation.RequestHeader;

import com.unimag.booking.dto.CreateBookingDto;
import com.unimag.booking.dto.ResponseBookingDto;

import jakarta.ws.rs.NotFoundException;

public interface BookingService {

    ResponseBookingDto createBooking(CreateBookingDto createBookingDto, @RequestHeader("Authorization") String bearerToken) throws NotFoundException;
    ResponseBookingDto getBookingById( String id) throws NotFoundException;
    ResponseBookingDto confirmedBooking(String bookingId); 

}
