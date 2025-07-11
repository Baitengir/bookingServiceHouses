package bookinghouse.service.impl;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.bookingDto.request.BookingRequest;
import bookinghouse.dto.bookingDto.response.BookingResponse;
import bookinghouse.entities.Booking;
import bookinghouse.entities.Customer;
import bookinghouse.entities.House;
import bookinghouse.myExceptions.HouseAlreadyBookedException;
import bookinghouse.repo.BookingRepo;
import bookinghouse.repo.CustomerRepo;
import bookinghouse.repo.HouseRepo;
import bookinghouse.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;
    private final HouseRepo houseRepo;
    private final CustomerRepo customerRepo;

    @Override
    public SimpleResponse createBooking(BookingRequest bookingRequest) {

        House houseInDb = houseRepo.findById(bookingRequest.houseId()).orElseThrow(
                () -> new NullPointerException(
                        String.format("House %s not found", bookingRequest.houseId()))
        );

        if (houseInDb.isBooked()) {
            throw new HouseAlreadyBookedException(
                    String.format("House %s already booked",
                            bookingRequest.houseId()));
        }

        Customer customer = customerRepo.findById(bookingRequest.customerId()).orElseThrow(
                () -> new NullPointerException(
                        String.format("Customer %s not found", bookingRequest.customerId()))
        );

        Booking booking = new Booking();
        houseInDb.setBooked(true);
        booking.setHouse(houseInDb);
        booking.setCustomer(customer);
        booking.setCreatedDate(LocalDate.now());

        bookingRepo.save(booking);
        // todo если новый статус дома из базы данных не сохраниться я напишу сюда HouseRepo.save(houseInDb)

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Booking created")
                .build();
    }

    @Override
    public BookingResponse getById(Long id) {
        return null;
    }

    @Override
    public List<BookingResponse> getAll() {
        return List.of();
    }

    @Override
    public SimpleResponse delete(Long id) {
        return null;
    }
}
