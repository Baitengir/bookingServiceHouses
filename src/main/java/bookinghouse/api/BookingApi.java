package bookinghouse.api;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.bookingDto.request.BookingRequest;
import bookinghouse.dto.bookingDto.response.BookingResponse;
import bookinghouse.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")

public class BookingApi {
    private final BookingService bookingService;

    @PostMapping()
    public SimpleResponse createBooking (@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }

    @GetMapping("/{id}")
    public BookingResponse getById (@PathVariable Long id) {
        return bookingService.getById(id);
    }

    @GetMapping()
    public List<BookingResponse> getAllBookings () {
        return bookingService.getAll();
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete (@PathVariable Long id) {
        return bookingService.delete(id);
    }
}
