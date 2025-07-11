package bookinghouse.service;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.dto.houseDto.request.HouseRequest;
import bookinghouse.dto.houseDto.request.HouseUpdateRequest;
import java.util.List;

public interface HouseService {
    SimpleResponse saveHouseByAgencyId (Long id, HouseRequest houseRequest);
    HouseResponse getById(Long id);
    List<HouseResponse> getAll();
    SimpleResponse update(Long id, HouseUpdateRequest houseUpdateRequest);
    SimpleResponse delete(Long id);
    List<HouseResponse> getAllFreeHouses();
}
