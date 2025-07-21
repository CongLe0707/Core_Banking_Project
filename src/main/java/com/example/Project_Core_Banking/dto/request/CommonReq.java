package com.example.Project_Core_Banking.dto.request;

import com.example.Project_Core_Banking.anotation.DatePattern;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommonReq <T>{
    @NotBlank
    private final String requestId;

    @NotBlank
    @DatePattern
    private final String requestTime;

    @NotBlank
    private final String channel;

    @NotBlank
    private final String subChannel;

    private final String partnerId;

    private final String signature;

    @NotNull
    @Valid
    private final T data;

    @JsonCreator
    public CommonReq(
            @JsonProperty("requestId") String requestId,
            @JsonProperty("requestTime") String requestTime,
            @JsonProperty("channel") String channel,
            @JsonProperty("subChannel") String subChannel,
            @JsonProperty("partnerId") String partnerId,
            @JsonProperty("data") T data,
            @JsonProperty("signature") String signature

    ) {
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.channel = channel;
        this.subChannel = subChannel;
        this.partnerId = partnerId;
        this.data = data;
        this.signature = signature;

    }
}
