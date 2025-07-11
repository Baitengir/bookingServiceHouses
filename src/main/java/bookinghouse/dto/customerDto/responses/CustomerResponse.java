package bookinghouse.dto.customerDto.responses;

import bookinghouse.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    Long id;
    String name;
    String surname;
    Gender gender;
    String phone;
    LocalDate dateOfBirth;
}
