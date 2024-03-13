package com.website.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody Customer customer) {
        log.info("new customer registration {}", customer);
        customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        log.info("get customer request {}", id);
        return customerService.getCustomer(id);
    }

}
