package com.example.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud-service")
public interface FraudClient {

    @GetMapping(path = "api/fraud-check/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
