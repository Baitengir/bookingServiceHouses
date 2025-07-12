package bookinghouse.dto.bookingDto.response;

import bookinghouse.entities.Customer;
import bookinghouse.entities.House;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BookingResponse {
    Long id;
    Long customerId;
    Long houseId;
}
