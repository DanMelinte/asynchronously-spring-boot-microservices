package com.example.Controller;

import com.example.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.Service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCostumer(customerId);
        log.info("fraud check request for customer{}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}