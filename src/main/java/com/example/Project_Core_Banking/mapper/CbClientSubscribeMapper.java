package com.example.Project_Core_Banking.mapper;

import com.example.Project_Core_Banking.dto.request.RegistrationReq;
import com.example.Project_Core_Banking.entity.CbAccountProfit;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, OffsetDateTime.class})
public abstract class CbClientSubscribeMapper {

    @Autowired
    protected ObjectMapper objectMapper;

    protected String cleanString(String value) {
        if (value == null) return null;
        return value.trim();
    }



    protected OffsetDateTime parseSubscribeDate(String dateStr) {
        if (dateStr == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSXXX");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate.atStartOfDay().atOffset(ZoneOffset.UTC);
    }

    @Mappings({
            @Mapping(target = "subscribeId", expression = "java(UUID.randomUUID())"),
            @Mapping(target = "channel", expression = "java(req.getData().channel())"),
            @Mapping(target = "subChannel", expression = "java(req.getData().subChannel())"),
            @Mapping(target = "clientNo", expression = "java(req.getData().clientNo())"),
            @Mapping(target = "acctNo", expression = "java(req.getData().acctNo())"),
            @Mapping(target = "subscribeDate", expression = "java(parseSubscribeDate(req.getData().subscribeDate()))"),
            @Mapping(target = "subscribeType", expression = "java(req.getData().subscribeType())"),
            @Mapping(target = "subscribeData", expression = "java(convertSubscribeDataToJson(req.getData().subscribeData()))"),
            @Mapping(target = "statusProcess", constant = "NEW"),
            @Mapping(target = "statusDc", ignore = true),
            @Mapping(target = "statusAccountProfit", ignore = true),
            @Mapping(target = "statusContract", ignore = true),
            @Mapping(target = "statusOtt", ignore = true),
            @Mapping(target = "requestId", expression = "java(req.getRequestId())"),
            @Mapping(target = "userChannel", ignore = true),
            @Mapping(target = "accountProfitId", ignore = true),
            @Mapping(target = "transNo", ignore = true),
            @Mapping(target = "createdDate", expression = "java(OffsetDateTime.now())"),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "createdWsId", ignore = true)
    })
    public abstract CbAccountProfit toEntity(@NotNull @Valid RegistrationReq req);
}