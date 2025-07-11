package bookinghouse.api;

import bookinghouse.dto.agencyDto.request.AgencyRequest;
import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.agencyDto.response.AgencyResponse;
import bookinghouse.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agencies")
public class AgencyApi {
    private final AgencyService agencyService;

    @PostMapping()
    public SimpleResponse save(@RequestBody AgencyRequest agencyRequest) {
        return agencyService.save(agencyRequest);
    }

    @GetMapping("/{id}")
    public AgencyResponse getById(@PathVariable Long id) {
        return agencyService.getById(id);
    }

    @GetMapping()
    public List<AgencyResponse> getAll() {
        return agencyService.getAll();
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id, @RequestBody AgencyRequest agencyRequest) {
        return agencyService.update(id, agencyRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return agencyService.delete(id);
    }
}
