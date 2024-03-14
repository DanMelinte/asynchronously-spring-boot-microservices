package com.website.customer.Service;


import com.website.customer.Entities.CustomerRegistrationRequest;
import com.website.customer.Repository.CustomerRepository;
import com.website.customer.Entities.Customer;
import com.website.customer.Exceptions.ApiRequestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    //Business CRUD layer (include CRUD,validation,throw exception)

    public void registerCustomer(CustomerRegistrationRequest request) {
        //email validation

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

//direct request
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://localhost:8081/api/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );

        //eureka handle request
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD-SERVICE:8081/api/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );


        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ApiRequestNotFoundException("Customer with id=" + id + " was not found"));
    }


}
