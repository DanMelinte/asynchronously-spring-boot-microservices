package com.fraud.Service;

import com.fraud.Entities.FraudCheckHistory;
import com.fraud.Repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository ) {
    public boolean isFraudulentCostumer(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdTime(LocalDateTime.now())
                        .build()
        );
        fraudCheckHistoryRepository.saveAndFlush(fraudCheckHistory);
        return false;
    }
}
