package bookinghouse.service.impl;

import bookinghouse.dto.SimpleResponse;
import bookinghouse.dto.customerDto.requests.CustomerRequest;
import bookinghouse.dto.customerDto.responses.CustomerResponse;
import bookinghouse.entities.Customer;
import bookinghouse.repo.CustomerRepo;
import bookinghouse.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public SimpleResponse save(CustomerRequest customerRequest) {
        Customer customer = new Customer();

        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        customer.setSurname(customerRequest.surname());
        if (!customerRequest.phone().matches("^\\+996\\d{9}$")) {
            throw new IllegalArgumentException("Phone number must start with +996 and contain 9 digits after it");
        }
        customer.setPhone(customerRequest.phone());
        customer.setDateOfBirth(customerRequest.dateOfBirth());
        customer.setGender(customerRequest.gender());
        customerRepo.save(customer);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Customer successfully saved")
                .build();
    }

    @Override
    public CustomerResponse getById(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Customer with id %s not found", id))
        );
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setSurname(customer.getSurname());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.setDateOfBirth(customer.getDateOfBirth());
        customerResponse.setGender(customer.getGender());

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> getAll() {

        List<Customer> customers = customerRepo.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();

        customers.forEach(customer -> {
            CustomerResponse customerResponse = new CustomerResponse();

            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setSurname(customer.getSurname());
            customerResponse.setPhone(customer.getPhone());
            customerResponse.setDateOfBirth(customer.getDateOfBirth());
            customerResponse.setGender(customer.getGender());
            customerResponses.add(customerResponse);
        });

        return customerResponses;
    }

    @Override
    public SimpleResponse updateById(Long id, CustomerRequest customerRequest) {

        Customer customer = customerRepo.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("Customer with id %s not found", id))
        );

        customer.setName(customerRequest.name());
        customer.setSurname(customerRequest.surname());
        customer.setPhone(customerRequest.phone());
        customer.setDateOfBirth(customerRequest.dateOfBirth());
        customer.setGender(customerRequest.gender());

        customerRepo.save(customer);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Customer successfully updated")
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        customerRepo.deleteById(id);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Customer successfully deleted")
                .build();
    }
}
