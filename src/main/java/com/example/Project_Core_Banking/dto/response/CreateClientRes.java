package com.example.Project_Core_Banking.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateClientRes (
        UUID clientId,
        String clientNo,
        String clientName,
        String clientStatus,
        OffsetDateTime createdDate,
        String createdBy
) {

}
