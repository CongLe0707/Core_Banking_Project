package com.example.Project_Core_Banking.mapper;

import com.example.Project_Core_Banking.dto.request.CreateClientReq;
import com.example.Project_Core_Banking.dto.response.CreateClientRes;
import com.example.Project_Core_Banking.entity.CbClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, OffsetDateTime.class})
public abstract class CbClientMapper {
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
            @Mapping(target = "clientId", source = "clientId"),
            @Mapping(target = "clientNo", source = "clientNo"),
            @Mapping(target = "clientName", source = "clientName"),
            @Mapping(target = "clientStatus", source = "clientStatus"),
            @Mapping(target = "createdDate", source = "createdDate"),
            @Mapping(target = "createdBy", source = "createdBy")
    })
    public abstract CreateClientRes toDto(CbClient entity);

    @Mapping(target = "clientStatus", constant = "ACTIVE")
    public abstract CbClient toEntity(CreateClientReq req);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateEntityFromDto(UUID dto, @MappingTarget CbClient entity) {
    }
}
