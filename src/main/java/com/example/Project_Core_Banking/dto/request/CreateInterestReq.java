package com.example.Project_Core_Banking.dto.request;

public record CreateInterestReq (
        int term,
        float interest
) {
}
