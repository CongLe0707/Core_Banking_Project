package com.example.Project_Core_Banking.dto.request;

import com.example.Project_Core_Banking.anotation.DatePattern;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateCardClientReq (
        UUID clientId,
        String passCard,
        String  clientName,
        String address,
        String email,
        String idCard,
        Double balance,
        @DatePattern
        String timeReq,
        String note,
        String phone

) {
}
