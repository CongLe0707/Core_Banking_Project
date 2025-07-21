package com.example.Project_Core_Banking.dto.response;

import com.example.Project_Core_Banking.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.example.Project_Core_Banking.enums.ResultCode.SUCCESS;
import static com.example.Project_Core_Banking.utils.DateTimeUtils.YYYY_MM_DD_T_HH_MM_SS_SSS;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonRes<T>(String resultStatus, String resultMessage, String responseTime, T data) {
    public CommonRes(T data) {
        this(SUCCESS.getCode(), SUCCESS.getMessage(), DateTimeUtils.currentDate(YYYY_MM_DD_T_HH_MM_SS_SSS), data);
    }

    public CommonRes(String responseCode, String responseMessage) {
        this(responseCode, responseMessage, DateTimeUtils.currentDate(YYYY_MM_DD_T_HH_MM_SS_SSS), null);
    }
}