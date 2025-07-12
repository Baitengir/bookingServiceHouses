package bookinghouse.service;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.bookingDto.response.BookingResponse;
import bookinghouse.dto.customerDto.requests.CustomerRequest;
import bookinghouse.dto.customerDto.responses.CustomerResponse;

import java.util.List;

public interface CustomerService {
    SimpleResponse save (CustomerRequest customerRequest);
    CustomerResponse getById (Long id);
    List<CustomerResponse> getAll ();
    SimpleResponse updateById (Long id, CustomerRequest customerRequest);
    SimpleResponse deleteById (Long id);
    List<CustomerResponse> searchByNameOrSurname (String searchName);
    int gerTotalBookingsByCustomerId (Long id);
    List<BookingResponse> getBookingsByCustomerId (Long id);
}
