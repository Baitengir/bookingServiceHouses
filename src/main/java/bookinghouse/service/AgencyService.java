package bookinghouse.service;

import bookinghouse.dto.agencyDto.request.AgencyRequest;
import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.agencyDto.response.AgencyResponse;
import bookinghouse.dto.houseDto.response.HouseResponse;

import java.util.List;

public interface AgencyService {
    SimpleResponse save (AgencyRequest agencyRequest);
    AgencyResponse getById(Long id);
    List<AgencyResponse> getAll();
    SimpleResponse update(Long id, AgencyRequest agencyRequest);
    SimpleResponse delete(Long id);
    List<HouseResponse> getAllHousesByAgencyId(Long id);
}
