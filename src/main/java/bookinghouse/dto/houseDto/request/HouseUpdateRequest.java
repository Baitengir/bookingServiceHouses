package bookinghouse.dto.houseDto.request;

public record HouseUpdateRequest(
        int price,
        String description,
        boolean isBooked
) {
}
