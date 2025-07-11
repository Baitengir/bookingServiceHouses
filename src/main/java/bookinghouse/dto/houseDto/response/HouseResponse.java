package bookinghouse.dto.houseDto.response;

import bookinghouse.enums.HouseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponse {
    Long id;
    HouseType houseType;
    String address;
    int price;
    int rooms;
    String country;
    String description;
}
