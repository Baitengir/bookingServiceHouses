package bookinghouse.api;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.customerDto.requests.CustomerRequest;
import bookinghouse.dto.customerDto.responses.CustomerResponse;
import bookinghouse.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerApi {
    private final CustomerService customerService;

    @PostMapping()
    public SimpleResponse save (@RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @GetMapping("/{id}")
    public CustomerResponse getById (@PathVariable Long id) {
        return customerService.getById(id);
    }

    @GetMapping()
    public List<CustomerResponse> getAll () {
        return customerService.getAll();
    }

    @PutMapping("/{id}")
    public SimpleResponse update (@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        return customerService.updateById(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteById (@PathVariable Long id) {
        return customerService.deleteById(id);
    }
}
