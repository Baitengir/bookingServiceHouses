package bookinghouse.dto.houseDto.response;

import bookinghouse.enums.HouseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class HouseResponse {
    Long id;
    HouseType houseType;
    String address;
    int price;
    int rooms;
    String country;
    String description;

    public HouseResponse() {
    }

    public HouseResponse(Long id, HouseType houseType, String address, int price, int rooms, String country, String description) {
        this.id = id;
        this.houseType = houseType;
        this.address = address;
        this.price = price;
        this.rooms = rooms;
        this.country = country;
        this.description = description;
    }
}
