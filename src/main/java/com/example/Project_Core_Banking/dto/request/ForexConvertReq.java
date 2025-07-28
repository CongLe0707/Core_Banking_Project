package com.example.Project_Core_Banking.dto.request;

public record ForexConvertReq (
        String fromCurrency,
        String toCurrency,
        double amount
) {
}
