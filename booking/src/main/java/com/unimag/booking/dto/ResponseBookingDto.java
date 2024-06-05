package com.unimag.booking.dto;

import java.time.LocalDateTime;

import com.unimag.booking.enums.BookingStatus;

public record ResponseBookingDto( 
    String id,
    String carId,
    String customerId,
    BookingStatus status,
    LocalDateTime startDate,
    LocalDateTime endDate
    ) {}
