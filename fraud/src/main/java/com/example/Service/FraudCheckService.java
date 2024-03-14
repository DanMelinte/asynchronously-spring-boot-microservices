package com.example.Service;

import com.example.Entities.FraudCheckHistory;
import com.example.Repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    public boolean isFraudulentCostumer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdTime(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
