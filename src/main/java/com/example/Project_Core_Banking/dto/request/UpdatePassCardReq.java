package com.example.Project_Core_Banking.dto.request;

public record UpdatePassCardReq (
        String clientNo,
        String passCard,
        String newPassCard
) {
}
