package com.example.Project_Core_Banking.mapper;

import com.example.Project_Core_Banking.dto.request.CreateCardClientReq;
import com.example.Project_Core_Banking.dto.response.CreateCardClientRes;
import com.example.Project_Core_Banking.entity.CbCardClient;
import com.example.Project_Core_Banking.entity.CbClient;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public abstract class CbCardClientMapper {
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

            @Mapping(target = "clientId", source = "req.clientId") ,// liên kết entity
            @Mapping(target = "clientNo", source = "client.clientNo"), // map từ entity
            @Mapping(target = "clientName", expression = "java(cleanString(req.clientName()))"),
            @Mapping(target = "address", expression = "java(cleanString(req.address()))"),
            @Mapping(target = "idCard", source = "req.idCard"),
            @Mapping(target = "email", source = "req.email"),
            @Mapping(target = "balance", source = "req.balance"),
            @Mapping(target = "timeReq", source = "req.timeReq"),
            @Mapping(target = "note", constant = ""), // default rỗng
            @Mapping(target = "passCard", source = "req.passCard"),
            @Mapping(target = "phone", source = "req.phone")
    })
    public abstract CbCardClient toEntity(CreateCardClientReq req, CbClient client);

    public  abstract CreateCardClientRes ToDto(CbCardClient entity);
}
