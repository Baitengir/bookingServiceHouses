package bookinghouse.service.impl;

import bookinghouse.dto.agencyDto.request.AgencyRequest;
import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.agencyDto.response.AgencyResponse;
import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.entities.Agency;
import bookinghouse.repo.AgencyRepo;
import bookinghouse.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepo agencyRepo;

    @Override
    public SimpleResponse save(AgencyRequest agencyRequest) {
        Agency agency = new Agency();
        agency.setName(agencyRequest.name());
        agency.setPhone(agencyRequest.phone());
        agency.setEmail(agencyRequest.email());
        agency.setCountry(agencyRequest.country());
        agencyRepo.save(agency);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Agency successfully saved")
                .build();
    }

    @Override
    public AgencyResponse getById(Long id) {
        Agency agency = agencyRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("Agency with id %s not found", id))
        );
        return AgencyResponse.builder()
                .id(agency.getId())
                .name(agency.getName())
                .phone(agency.getPhone())
                .country(agency.getCountry())
                .build();
    }

    @Override
    public List<AgencyResponse> getAll() {
        List <AgencyResponse> agencyResponses = new ArrayList<>();
        List<Agency> agencies = agencyRepo.findAll();

        agencies.forEach(agency -> {
            AgencyResponse agencyResponse = new AgencyResponse();

            agencyResponse.setId(agency.getId());
            agencyResponse.setName(agency.getName());
            agencyResponse.setPhone(agency.getPhone());
            agencyResponse.setCountry(agency.getCountry());
            agencyResponses.add(agencyResponse);
        });
        return agencyResponses;
    }

    @Override
    public SimpleResponse update(Long id, AgencyRequest agencyRequest) {

        Agency agencyInDb = agencyRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("Agency with id %s not found", id))
        );

        agencyInDb.setName(agencyRequest.name());
        agencyInDb.setPhone(agencyRequest.phone());
        agencyInDb.setCountry(agencyRequest.country());
        agencyRepo.save(agencyInDb);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        try {
            agencyRepo.deleteById(id);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("Check id")
                    .build();
        }
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully deleted")
                .build();
    }

    @Override
    public List<HouseResponse> getAllHousesByAgencyId(Long id) {
        return agencyRepo.getAllHousesByAgencyId(id);
    }

}
