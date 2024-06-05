package com.unimag.booking.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.unimag.booking.entities.Booking;
import com.unimag.booking.enums.BookingStatus;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "startDate", expression = "java(null)")
    @Mapping(target = "endDate", expression = "java(null)")
    @Mapping(target="status", expression = "java(awaitingPaymentStatus())")
    Booking createBookingDtoToBooking(CreateBookingDto createBookingDto);

    ResponseBookingDto bookingToBookingDto(Booking booking);

    default BookingStatus awaitingPaymentStatus() {
        return BookingStatus.AWAITINGPAYMENT;
    }
}
