package bookinghouse.dto.agencyDto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgencyResponse {
    Long id;
    String name;
    String country;
    String phone;
}
