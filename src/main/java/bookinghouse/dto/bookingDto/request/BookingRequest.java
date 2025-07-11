package bookinghouse.dto.bookingDto.request;

import bookinghouse.entities.Customer;
import bookinghouse.entities.House;

public record BookingRequest (
        Long customerId,
        Long houseId
){
}
