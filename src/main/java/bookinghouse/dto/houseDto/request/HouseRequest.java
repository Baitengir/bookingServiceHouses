package bookinghouse.dto.houseDto.request;

import bookinghouse.enums.HouseType;

public record HouseRequest (
        HouseType houseType,
        String address,
        int price,
        int rooms,
        String country,
        String description
){
}
