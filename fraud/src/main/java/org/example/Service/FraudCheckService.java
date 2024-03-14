package org.example.Service;

import lombok.AllArgsConstructor;
import org.example.Entities.FraudCheckHistory;
import org.example.Repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

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
