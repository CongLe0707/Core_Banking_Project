package com.example.Project_Core_Banking.mapper;

import com.example.Project_Core_Banking.dto.request.CreateInterestReq;
import com.example.Project_Core_Banking.entity.CbInterest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, OffsetDateTime.class})
public abstract class CbInterestMapper {
    @Mapping(target = "interestId", ignore = true) // UUID sẽ tự sinh
    public abstract CbInterest toEntity(CreateInterestReq req);
}
