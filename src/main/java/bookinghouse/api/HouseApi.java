package bookinghouse.api;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.dto.houseDto.request.HouseRequest;
import bookinghouse.dto.houseDto.request.HouseUpdateRequest;
import bookinghouse.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseApi {
    private final HouseService houseService;

    @PostMapping("/{id}")
    public SimpleResponse save (@PathVariable Long id, @RequestBody HouseRequest houseRequest) {
        return houseService.saveHouseByAgencyId(id, houseRequest);
    }

    @GetMapping("/{id}")
    public HouseResponse getById (@PathVariable Long id) {
        return houseService.getById(id);
    }

    @GetMapping()
    public List<HouseResponse> getAll () {
        return houseService.getAll();
    }

    @PutMapping("/{id}")
    public SimpleResponse update (@PathVariable Long id, @RequestBody HouseUpdateRequest houseUpdateRequest) {
        return houseService.update(id, houseUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete (@PathVariable Long id) {
        return houseService.delete(id);
    }

    @GetMapping("/freeHouses")
    public List<HouseResponse> getAllFreeHouses () {
        return houseService.getAllFreeHouses();
    }
}
