package com.example.Project_Core_Banking.dto.response;

import com.example.Project_Core_Banking.entity.CbCardClient;

import java.time.OffsetDateTime;
import java.util.UUID;

public record HistoryRes (
        UUID historyId,
        CbCardClient cbCardClient,
        Double amount,
        Double remainingBalance,
        String transactionType,
        String note,
        String status,
        OffsetDateTime transactionTime
) {
}
