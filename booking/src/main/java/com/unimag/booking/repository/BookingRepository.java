package com.unimag.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimag.booking.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {
    
}
