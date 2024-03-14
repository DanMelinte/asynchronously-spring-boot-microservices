package com.website.customer.Controller;


import com.website.customer.Entities.CustomerRegistrationRequest;
import com.website.customer.Service.CustomerService;
import com.website.customer.Entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        log.info("new customer registration {}", request);
        customerService.registerCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        log.info("get customer request {}", id);
        return customerService.getCustomer(id);
    }

}
