package org.example.clients;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud"
)
public interface FraudClient {
    @GetMapping(path = "api/api/fraud-check/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);


}
