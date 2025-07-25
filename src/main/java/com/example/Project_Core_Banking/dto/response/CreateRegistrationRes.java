package com.example.Project_Core_Banking.dto.response;

import java.util.UUID;

public record CreateRegistrationRes (
        UUID subscribeId,
        String statusProcess,
        String clientNo,
        String acctNo
) {
}
