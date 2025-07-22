package com.example.Project_Core_Banking.dto.response;

import com.example.Project_Core_Banking.anotation.DatePattern;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateCardClientRes (
        UUID clientId,
        String clientNo,
        String passCard,
        String  clientName,
        String address,
        String email,
        String idCard,
        Double balance
) {
}
