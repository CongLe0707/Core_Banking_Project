package com.example.Project_Core_Banking.dto.request;

public record DepositReq (
        String clientNo,
        String passCard,
        Double amount

) {
}
