package bookinghouse.dto.customerDto.requests;

import bookinghouse.enums.Gender;
import java.time.LocalDate;

public record CustomerRequest(
        String name,
        String surname,
        String email,
        Gender gender,
        String phone,
        LocalDate dateOfBirth
) {
}
