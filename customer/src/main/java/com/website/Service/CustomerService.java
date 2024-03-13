package com.website.Service;


import com.website.Repository.CustomerRepository;
import com.website.Entities.Customer;
import com.website.Exceptions.ApiRequestNotFoundException;
import org.springframework.stereotype.Service;


@Service
public record CustomerService(CustomerRepository customerRepository) {
    //Business CRUD layer (include CRUD,validation,throw exception)

    public void registerCustomer(Customer request) {
        //email validation

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.save(customer);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ApiRequestNotFoundException("Customer with id=" + id + " was not found"));
    }
}
