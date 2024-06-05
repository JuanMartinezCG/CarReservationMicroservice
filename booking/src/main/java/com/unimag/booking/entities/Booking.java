package com.unimag.booking.entities;

import java.time.LocalDateTime;

import com.unimag.booking.enums.BookingStatus;

import jakarta.persistence.*;
import lombok.*;

@Table(name="bookings")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String carId;

    private String customerId;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;
}
