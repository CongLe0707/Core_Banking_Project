package com.example.Project_Core_Banking.dto.response;

public record DepositRes (
        String clientNo,
        String  clientName,
        Double amount,
        Double balance
) {
}
