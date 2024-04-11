package com.clients.openFeign.fraud;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("fraud-service")
@FeignClient(
        name = "fraud-service",
        url = "${clients.openFeign.fraud.url}"
)
public interface FraudClient  {

    @GetMapping(path = "api/fraud-check/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
