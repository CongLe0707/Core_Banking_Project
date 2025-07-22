package com.example.Project_Core_Banking.dto.response;

public record LoginRes (
    String accessToken,
    String refreshToken,
    String type
) {
    public LoginRes(String accessToken, String refreshToken) {
            this(accessToken, refreshToken, "Bearer");
        }
}
