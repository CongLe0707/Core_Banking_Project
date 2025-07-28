package com.example.Project_Core_Banking.dto.response;

import java.time.LocalDateTime;

public record ForexConvertRes (
        double originalAmount,
        double convertedAmount,
        double rate,
        String fromCurrency,
        String toCurrency,
        LocalDateTime timestamp
){
}
