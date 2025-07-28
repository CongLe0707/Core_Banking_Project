package com.example.Project_Core_Banking.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record SavingInterestRes (
        double originalAmount,
        // Số tiền lãi tính được
        double interestAmount,
        // Tổng số tiền nhận được khi đáo hạn (gốc + lãi)
        double totalAmount,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate maturityDate,

        // Lãi suất áp dụng (%)
        double interestRate,
        // Kỳ hạn gửi (tháng)
        int termInMonths
) {
}
