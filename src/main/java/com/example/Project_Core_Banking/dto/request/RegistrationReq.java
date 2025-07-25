package com.example.Project_Core_Banking.dto.request;

import com.example.Project_Core_Banking.anotation.DatePattern;
import com.example.Project_Core_Banking.anotation.PhoneNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegistrationReq (
        @NotBlank String channel, String subChannel, @NotBlank String clientNo, @NotBlank String acctNo,
        @NotBlank @DatePattern String subscribeDate, @NotBlank String subscribeType, @Valid @NotNull SubscribeData subscribeData
) {
    public record SubscribeData(@NotBlank String clientName, String clientShortName, @NotBlank String clientAddress,
                                String clientNationality, @NotBlank @PhoneNumber(required = true) String phone,
                                @PhoneNumber String phoneNd, String email,
                                String clientStatus, String branch, String note, String extendData,
                                @Valid @NotNull List<GlobalInfo> globalInfo, @Valid @NotNull AcctInfo acctInfo
                                ) {}
    public record GlobalInfo(@NotBlank String globalId, @NotBlank String globalType, String issuePlace, String issueAuth,
                             @DatePattern String issueDate, @DatePattern String expiredDate){}
    public record AcctInfo(@NotBlank String acctNo, @NotBlank String acctType,String ccy, String acctDesc, String acctAlias){}
}

