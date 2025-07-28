package com.example.Project_Core_Banking.dto.response;

import java.util.UUID;

public record CreateInterestRes(
        UUID interestId,
        int term,
        float interest
) {
}
