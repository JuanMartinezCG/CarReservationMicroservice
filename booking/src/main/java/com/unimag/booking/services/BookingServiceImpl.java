package com.unimag.booking.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.unimag.booking.client.CarInventoryClient;
import com.unimag.booking.dto.BookingMapperImpl;
import com.unimag.booking.dto.CreateBookingDto;
import com.unimag.booking.dto.ResponseBookingDto;

import com.unimag.booking.entities.Booking;
import com.unimag.booking.event.CustomEvent;
import com.unimag.booking.exceptions.carInventory.CarReserveException;
import com.unimag.booking.producers.EventPublisher;
import com.unimag.booking.repository.BookingRepository;

import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final CarInventoryClient carInventoryClient;
    private final BookingMapperImpl bookingMapper;

    @Autowired
    private EventPublisher eventPublisher;
    

    @Override
    public ResponseBookingDto createBooking(CreateBookingDto createBookingDto, @RequestHeader("Authorization") String bearerToken) throws NotFoundException  {
        
        if(createBookingDto.carId().isEmpty()) throw new NotFoundException();

        try {
            this.carInventoryClient.carReserve(createBookingDto.carId(), bearerToken);
        } catch (Exception e) {
            throw new CarReserveException("No se ha podido reservar el auto, verifique que esté disponible," +
            "el token recivido fue: " + bearerToken);
        }

        Booking newBooking = this.bookingMapper.createBookingDtoToBooking(createBookingDto);

        Booking savedBooking  = this.bookingRepository.save(newBooking);

        return this.bookingMapper.bookingToBookingDto(savedBooking);

    }

    @Override
    public ResponseBookingDto getBookingById(String id) throws NotFoundException {
        Optional<Booking> booking = this.bookingRepository.findById(id);
        if(!booking.isPresent()) throw new NotFoundException();

        return this.bookingMapper.bookingToBookingDto(booking.get());
    }

    @Override
    public ResponseBookingDto confirmedBooking(String bookingId) {
        throw new UnsupportedOperationException("Unimplemented method 'confirmedBooking'");
    }

    public void someMethod() {
        CustomEvent event = new CustomEvent("Mensaje a enviar");
        eventPublisher.publishEvent(event);
    }


}
