package bookinghouse.service;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.bookingDto.request.BookingRequest;
import bookinghouse.entities.Booking;

public interface BookingService {
    SimpleResponse createBooking (BookingRequest bookingRequest);

}