package bookinghouse.dto.customerDto.responses;

import bookinghouse.enums.Gender;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CustomerResponse {
    Long id;
    String name;
    String surname;
    Gender gender;
    String phone;
    LocalDate dateOfBirth;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String surname, Gender gender, String phone, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
}
