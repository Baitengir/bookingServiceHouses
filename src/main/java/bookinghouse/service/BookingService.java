package bookinghouse.service;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.bookingDto.request.BookingRequest;
import bookinghouse.dto.bookingDto.response.BookingResponse;
import java.util.List;

public interface BookingService {

    SimpleResponse createBooking (BookingRequest bookingRequest);
    BookingResponse getById (Long id);
    List<BookingResponse> getAll();
    SimpleResponse delete (Long id);

}