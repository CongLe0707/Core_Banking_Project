package com.example.Project_Core_Banking.dto.request;

import java.time.LocalDate;

public record SavingInterestReq(
        double principalAmount,
        LocalDate startDate,
        int term
) {
}
