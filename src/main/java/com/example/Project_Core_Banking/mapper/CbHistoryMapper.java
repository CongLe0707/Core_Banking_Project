package com.example.Project_Core_Banking.mapper;

import com.example.Project_Core_Banking.dto.response.HistoryRes;
import com.example.Project_Core_Banking.entity.CbHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CbHistoryMapper {
    HistoryRes toDto(CbHistory cbHistory);
}













