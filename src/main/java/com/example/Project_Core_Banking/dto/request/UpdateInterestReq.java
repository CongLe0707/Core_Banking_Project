package com.example.Project_Core_Banking.dto.request;

import java.util.UUID;

public record UpdateInterestReq (
        UUID interestId,
        int term,
        float interest
) {
}
