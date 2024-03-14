package com.example.Service;


import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.Entities.CustomerRegistrationRequest;
import com.example.Repository.CustomerRepository;
import com.example.Entities.Customer;
import com.example.Exceptions.ApiRequestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
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

        //eureka handle request - service discovery
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://fraud-service:8081/api/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        //Open Feign request handler
//        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ApiRequestNotFoundException("Customer with id=" + id + " was not found"));
    }


}
