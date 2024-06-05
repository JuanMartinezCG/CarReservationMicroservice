package com.unimag.booking.services;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.unimag.booking.client.CarInventoryClient;
import com.unimag.booking.dto.BookingMapperImpl;
import com.unimag.booking.dto.CreateBookingDto;
import com.unimag.booking.dto.ResponseBookingDto;

import com.unimag.booking.entities.Booking;
import com.unimag.booking.exceptions.carInventory.CarReserveException;
import com.unimag.booking.repository.BookingRepository;

import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final CarInventoryClient carInventoryClient;
    private final BookingMapperImpl bookingMapper;
    

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
        // TODO Al hacer el pago la fecha de inicio debe quedar en la fecha actual
        // TODO Al hacer el pago el estado de la reserva debe quedar en ONGOING
        throw new UnsupportedOperationException("Unimplemented method 'confirmedBooking'");
    }
    
}
