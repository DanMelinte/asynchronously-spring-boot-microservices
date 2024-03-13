package com.website.customer;


import com.website.customer.exception_handling.NoSuchCustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = customerService.customerRepository().getById(id);

        if (customer == null) {
            System.out.println("==========");
            throw new NoSuchCustomerException("There is no employee with ID " + id + " in DB");
        }
        return customer;
    }
}
