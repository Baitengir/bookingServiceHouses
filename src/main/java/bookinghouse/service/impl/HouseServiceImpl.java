package bookinghouse.service.impl;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.dto.houseDto.request.HouseRequest;
import bookinghouse.dto.houseDto.request.HouseUpdateRequest;
import bookinghouse.entities.Agency;
import bookinghouse.entities.House;
import bookinghouse.repo.AgencyRepo;
import bookinghouse.repo.HouseRepo;
import bookinghouse.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepo houseRepo;
    private final AgencyRepo agencyRepo;

    @Override
    public SimpleResponse saveHouseByAgencyId(Long id, HouseRequest houseRequest) {
        House house = new House();

        Agency agency = agencyRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Invalid agency id: " + id)
        );

        house.setAddress(houseRequest.address());
        house.setCountry(houseRequest.country());
        house.setDescription(houseRequest.description());
        house.setPrice(houseRequest.price());
        house.setRooms(houseRequest.rooms());
        house.setHouseType(houseRequest.houseType());
        house.setAgency(agency);
        agency.getHouses().add(house);

        agencyRepo.save(agency);
        houseRepo.save(house);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("House successfully saved")
                .build();
    }

    @Override
    public HouseResponse getById(Long id) {

        House house = houseRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("House with id %s not found", id))
        );

        HouseResponse houseResponse = new HouseResponse();

        houseResponse.setId(house.getId());
        houseResponse.setHouseType(house.getHouseType());
        houseResponse.setPrice(house.getPrice());
        houseResponse.setRooms(house.getRooms());
        houseResponse.setAddress(house.getAddress());
        houseResponse.setCountry(house.getCountry());
        houseResponse.setDescription(house.getDescription());

        return houseResponse;
    }

    @Override
    public List<HouseResponse> getAll() {
        List<House> houses = houseRepo.findAll();
        List<HouseResponse> houseResponses = new ArrayList<>();

        for (House house : houses) {
            HouseResponse houseResponse = new HouseResponse();

            houseResponse.setId(house.getId());
            houseResponse.setHouseType(house.getHouseType());
            houseResponse.setPrice(house.getPrice());
            houseResponse.setRooms(house.getRooms());
            houseResponse.setAddress(house.getAddress());
            houseResponse.setCountry(house.getCountry());
            houseResponse.setDescription(house.getDescription());
            houseResponses.add(houseResponse);
        }
        return houseResponses;
    }

    @Override
    public SimpleResponse update(Long id, HouseUpdateRequest houseUpdateRequest) {
        House house = houseRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("House with id %s not found", id))
        );

        house.setDescription(houseUpdateRequest.description());
        house.setBooked(houseUpdateRequest.isBooked());
        house.setPrice(houseUpdateRequest.price());

        houseRepo.save(house);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("House successfully updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {

        House house = houseRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("House with id %s not found", id))
        );

        houseRepo.delete(house);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("House successfully deleted")
                .build();
    }

    @Override
    public List<HouseResponse> getAllFreeHouses() {
        return houseRepo.getAllFreeHouses();
    }

    @Override
    public List<HouseResponse> searchHousesByCountryAndRoom(String country, String room) {
        return houseRepo.searchHousesByCountryAndRoom(country, room);
    }

}
